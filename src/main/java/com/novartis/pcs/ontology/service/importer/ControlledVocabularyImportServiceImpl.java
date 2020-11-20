package com.novartis.pcs.ontology.service.importer;

import com.novartis.pcs.ontology.dao.ControlledVocabularyDAOLocal;
import com.novartis.pcs.ontology.dao.ControlledVocabularyDomainDAOLocal;
import com.novartis.pcs.ontology.dao.ControlledVocabularyTermDAOLocal;
import com.novartis.pcs.ontology.dao.DatasourceDAOLocal;
import com.novartis.pcs.ontology.entity.ControlledVocabulary;
import com.novartis.pcs.ontology.entity.ControlledVocabularyContext;
import com.novartis.pcs.ontology.entity.ControlledVocabularyDomain;
import com.novartis.pcs.ontology.entity.ControlledVocabularyTerm;
import com.novartis.pcs.ontology.entity.Curator;
import com.novartis.pcs.ontology.entity.Datasource;
import com.novartis.pcs.ontology.entity.InvalidEntityException;
import com.novartis.pcs.ontology.rest.json.controlledvocabulary.ControlledVocabularyDTO;
import com.novartis.pcs.ontology.rest.json.controlledvocabulary.TermDTO;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Stateless
@Local(ControlledVocabularyImportServiceLocal.class)
@Remote(ControlledVocabularyImportServiceRemote.class)
public class ControlledVocabularyImportServiceImpl implements ControlledVocabularyImportServiceLocal, ControlledVocabularyImportServiceRemote {
    protected Logger logger = Logger.getLogger(getClass().getName());

    @EJB
    protected DatasourceDAOLocal dataSourceDAO;

    @EJB
    protected ControlledVocabularyDomainDAOLocal domainDAO;

    @EJB
    protected ControlledVocabularyTermDAOLocal termDAO;

    @EJB
    protected ControlledVocabularyDAOLocal vocabularyDAO;


    @Override
    public void importControlledVocabulary(ControlledVocabularyDTO dto, Curator creator) throws InvalidEntityException {

        ControlledVocabulary vocabulary = getOrCreateVocabulary(dto, creator);

        Set<ControlledVocabularyTerm> terms = new HashSet<>(dto.getTerms().size());
        for (TermDTO termDTO : dto.getTerms()) {
            //TODO: What is the idea behind the usage count?
            ControlledVocabularyTerm term = new ControlledVocabularyTerm(vocabulary, termDTO.getName(), 1, creator);
            terms.add(term);
        }
        // TODO: Find out amount of terms that will be posted in one go, perhaps store them in batches?
        termDAO.saveAll(terms);
    }

    private ControlledVocabulary getOrCreateVocabulary(ControlledVocabularyDTO dto, Curator creator) throws InvalidEntityException {
        ControlledVocabulary vocabulary;
        vocabulary = vocabularyDAO.loadByName(dto.getName());

        if (vocabulary != null) {
            return vocabulary;
        } else {
            Datasource dataSource = getDatasource(dto);
            ControlledVocabularyDomain domain = getOrCreateDomain(dto, creator);
            ControlledVocabularyContext context = getContext(dto, creator);
            vocabulary = new ControlledVocabulary(dataSource, domain, context, dto.getName(), creator);
            vocabularyDAO.save(vocabulary);
            return vocabulary;
        }
    }

    private Datasource getDatasource(ControlledVocabularyDTO dto) throws InvalidEntityException {
        Datasource dataSource = dataSourceDAO.loadByAcronym(dto.getDataSourceAcronym());

        if (dataSource == null) {
            StringBuilder knownSources = new StringBuilder();
            for (Datasource knownSource : dataSourceDAO.loadAll()) {
                knownSources.append(", ");
                knownSources.append(knownSource.getAcronym());
            }
            knownSources.deleteCharAt(0);
            throw new InvalidEntityException(String.format(
                    "Data source %s could not be found, known data source acronyms are%s.",
                    dto.getDataSourceAcronym(), knownSources.toString()));
        }
        return dataSource;
    }

    private ControlledVocabularyDomain getOrCreateDomain(ControlledVocabularyDTO dto, Curator creator) throws InvalidEntityException {
        String domainName = dto.getDomain().getName() != null ? dto.getDomain().getName() : "UNKNOWN DOMAIN";

        ControlledVocabularyDomain domain = domainDAO.loadByName(domainName);

        if (domain == null) {
            logger.info("Creating new domain: " + domainName);
            domain = new ControlledVocabularyDomain(domainName, creator);
            domainDAO.save(domain);
        }
        return domain;
    }

    // TODO: Load or create and boilerplate DAOs
    private ControlledVocabularyContext getContext(ControlledVocabularyDTO dto, Curator creator) {
        return new ControlledVocabularyContext(dto.getContext(), creator);
    }
}
