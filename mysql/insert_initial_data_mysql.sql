-- Copyright 2015 Novartis Institutes for Biomedical Research
-- 
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- 
--     http://www.apache.org/licenses/LICENSE-2.0
-- 
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.


INSERT INTO CURATOR (
  CURATOR_ID, 
  USERNAME, 
  IS_ACTIVE, 
  CREATED_BY) 
VALUES (
  1, 
  'SYSTEM', 
  1,
  1);
 
INSERT INTO VERSION (
  VERSION_ID, 
  CREATED_BY)
VALUES (
  2,
  1);
  
INSERT INTO RELATIONSHIP_TYPE (
  RELATIONSHIP_TYPE_ID,
  RELATIONSHIP_TYPE,
  DEFINTION,
  IS_CYCLIC,
  IS_SYMMETRIC,
  IS_TRANSITIVE,
  EDGE_COLOUR,
  STATUS,
  CREATED_BY,
  CREATED_VERSION_ID,
  APPROVED_VERSION_ID
) VALUES (
  3,
  'is_a',
  'Subclassing relationship between one term and another',
  0,
  0,
  1,
  '#29477F',
  'APPROVED',
  1,
  2,
  2);
 
INSERT INTO RELATIONSHIP_TYPE (
  RELATIONSHIP_TYPE_ID,
  RELATIONSHIP_TYPE,
  DEFINTION,
  IS_CYCLIC,
  IS_SYMMETRIC,
  IS_TRANSITIVE,
  STATUS,
  CREATED_BY,
  CREATED_VERSION_ID,
  APPROVED_VERSION_ID
) VALUES (
  4,
  'union_of',
  'Represents the union of several other terms',
  0,
  0,
  0,
  'APPROVED',
  1,
  2,
  2);
  
INSERT INTO RELATIONSHIP_TYPE (
  RELATIONSHIP_TYPE_ID,
  RELATIONSHIP_TYPE,
  DEFINTION,
  IS_CYCLIC,
  IS_SYMMETRIC,
  IS_TRANSITIVE,
  STATUS,
  CREATED_BY,
  CREATED_VERSION_ID,
  APPROVED_VERSION_ID
) VALUES (
  5,
  'disjoint_from',
  'Terms have no instances or subclasses in common',
  0,
  1,
  0,
  'APPROVED',
  1,
  2,
  2);

INSERT INTO RELATIONSHIP_TYPE (
  RELATIONSHIP_TYPE_ID,
  RELATIONSHIP_TYPE,
  DEFINTION,
  IS_CYCLIC,
  IS_SYMMETRIC,
  IS_TRANSITIVE,
  EDGE_COLOUR,
  STATUS,
  CREATED_BY,
  CREATED_VERSION_ID,
  APPROVED_VERSION_ID
) VALUES (
  6,
  'part_of',
  'Subpart relationship between one term and another',
  0,
  0,
  1,
  '#923222',
  'APPROVED',
  1,
  2,
  2);
  
INSERT INTO RELATIONSHIP_TYPE (
  RELATIONSHIP_TYPE_ID,
  RELATIONSHIP_TYPE,
  DEFINTION,
  IS_CYCLIC,
  IS_SYMMETRIC,
  IS_TRANSITIVE,
  EDGE_COLOUR,
  STATUS,
  CREATED_BY,
  CREATED_VERSION_ID,
  APPROVED_VERSION_ID
) VALUES (
  7,
  'develops_from',
  'Anatomical structures change through development',
  0,
  0,
  1,
  '#329222',
  'APPROVED',
  1,
  2,
  2);  

INSERT INTO DATASOURCE (
  DATASOURCE_ID,
  DATASOURCE_NAME,
  DATASOURCE_ACRONYM,
  DATASOURCE_URI,
  IS_INTERNAL,
  IS_PUBLIC,
  CREATED_BY
) VALUES (
  8,
  'Clinical Data Interchange Standards Consortium',
  'CDISC',
  'http://www.cdisc.org',
  0,
  1,
  1);
  
INSERT INTO DATASOURCE (
  DATASOURCE_ID,
  DATASOURCE_NAME,
  DATASOURCE_ACRONYM,
  DATASOURCE_URI,
  IS_INTERNAL,
  IS_PUBLIC,
  CREATED_BY
) VALUES (
  9,
  'Standard for Exchange of Nonclinical Data',
  'SEND',
  'http://www.cdisc.org/send',
  0,
  1,
  1);
  
INSERT INTO DATASOURCE (
  DATASOURCE_ID,
  DATASOURCE_NAME,
  DATASOURCE_ACRONYM,
  DATASOURCE_URI,
  IS_INTERNAL,
  IS_PUBLIC,
  CREATED_BY
) VALUES (
  10,
  'National Cancer Institution Thesaurus',
  'NCI',
  'http://ncit.nci.nih.gov',
  0,
  1,
  1);

INSERT INTO DATASOURCE (
  DATASOURCE_ID,
  DATASOURCE_NAME,
  DATASOURCE_ACRONYM,
  DATASOURCE_URI,
  IS_INTERNAL,
  IS_PUBLIC,
  CREATED_BY
) VALUES (
  11,
  'Medical Dictionary for Regulatory Activities',
  'MedDRA',
  'http://www.meddramsso.com',
  0,
  1,
  1);
  
INSERT INTO DATASOURCE (
  DATASOURCE_ID,
  DATASOURCE_NAME,
  DATASOURCE_ACRONYM,
  DATASOURCE_URI,
  IS_INTERNAL,
  IS_PUBLIC,
  CREATED_BY
) VALUES (
  12,
  'International Harmonization of Nomenclature and Diagnostic',
  'INHAND',
  'http://www.toxpath.org/inhand.asp',
  0,
  1,
  1);

INSERT INTO DATASOURCE (
  DATASOURCE_ID,
  DATASOURCE_NAME,
  DATASOURCE_ACRONYM,
  DATASOURCE_URI,
  IS_INTERNAL,
  IS_PUBLIC,
  CREATED_BY
) VALUES (
  13,
  'Medical Subject Headings',
  'MeSH',
  'http://www.nlm.nih.gov/mesh/',
  0,
  1,
  1);

INSERT INTO DATASOURCE (
  DATASOURCE_ID,
  DATASOURCE_NAME,
  DATASOURCE_ACRONYM,
  DATASOURCE_URI,
  IS_INTERNAL,
  IS_PUBLIC,
  CREATED_BY
) VALUES (
  14,
  'Systematized Nomenclature of Medicine',
  'SNOMED',
  'http://www.ihtsdo.org/snomed-ct',
  0,
  1,
  1);
