package org.lhasalimited.etransafe.wp6.clinical.api.model.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.lhasalimited.etransafe.wp6.clinical.api.model.DataClassKey;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * DataClassCriteria
 */

public class DataClassCriteria  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("dataClassKey")
  private DataClassKey dataClassKey;

  @JsonProperty("links")
  @Valid
  private List<Link> links = null;

  @JsonProperty("operator")
  private Operator operator;

  @JsonProperty("fieldCriteria")
  @Valid
  private List<DataClassFieldCriteria> fieldCriteria = null;

  public DataClassCriteria dataClassKey(DataClassKey dataClassKey) {
    this.dataClassKey = dataClassKey;
    return this;
  }

  /**
   * Get dataClassKey
   * @return dataClassKey
  */
  @ApiModelProperty(value = "")

  @Valid

  public DataClassKey getDataClassKey() {
    return dataClassKey;
  }

  public void setDataClassKey(DataClassKey dataClassKey) {
    this.dataClassKey = dataClassKey;
  }

  public DataClassCriteria links(List<Link> links) {
    this.links = links;
    return this;
  }

  public DataClassCriteria addLinksItem(Link linksItem) {
    if (this.links == null) {
      this.links = new ArrayList<>();
    }
    this.links.add(linksItem);
    return this;
  }

  /**
   * Get links
   * @return links
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Link> getLinks() {
    return links;
  }

  public void setLinks(List<Link> links) {
    this.links = links;
  }

  public DataClassCriteria operator(Operator operator) {
    this.operator = operator;
    return this;
  }

  /**
   * Get operator
   * @return operator
  */
  @ApiModelProperty(value = "")

  @Valid

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public DataClassCriteria fieldCriteria(List<DataClassFieldCriteria> fieldCriteria) {
    this.fieldCriteria = fieldCriteria;
    return this;
  }

  public DataClassCriteria addFieldCriteriaItem(DataClassFieldCriteria fieldCriteriaItem) {
    if (this.fieldCriteria == null) {
      this.fieldCriteria = new ArrayList<>();
    }
    this.fieldCriteria.add(fieldCriteriaItem);
    return this;
  }

  /**
   * Get fieldCriteria
   * @return fieldCriteria
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<DataClassFieldCriteria> getFieldCriteria() {
    return fieldCriteria;
  }

  public void setFieldCriteria(List<DataClassFieldCriteria> fieldCriteria) {
    this.fieldCriteria = fieldCriteria;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataClassCriteria dataClassCriteria = (DataClassCriteria) o;
    return Objects.equals(this.dataClassKey, dataClassCriteria.dataClassKey) &&
        Objects.equals(this.links, dataClassCriteria.links) &&
        Objects.equals(this.operator, dataClassCriteria.operator) &&
        Objects.equals(this.fieldCriteria, dataClassCriteria.fieldCriteria);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataClassKey, links, operator, fieldCriteria);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataClassCriteria {\n");
    
    sb.append("    dataClassKey: ").append(toIndentedString(dataClassKey)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    fieldCriteria: ").append(toIndentedString(fieldCriteria)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

