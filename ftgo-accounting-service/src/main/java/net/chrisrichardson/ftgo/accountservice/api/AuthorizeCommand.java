package net.chrisrichardson.ftgo.accountservice.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.eventuate.tram.commands.common.Command;
import net.chrisrichardson.ftgo.common.Money;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizeCommand implements Command {
  private long consumerId;
  private Long orderId;
  private Money orderTotal;

  private AuthorizeCommand() {
  }

  public AuthorizeCommand(long consumerId, Long orderId, Money orderTotal) {
    this.consumerId = consumerId;
    this.orderId = orderId;
    this.orderTotal = orderTotal;
  }

  public long getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(long consumerId) {
    this.consumerId = consumerId;
  }

  public Money getOrderTotal() {
    return orderTotal;
  }

  public void setOrderTotal(Money orderTotal) {
    this.orderTotal = orderTotal;
  }

  @JsonProperty("merchantOrderReference")
  public Long getOrderId() {

    return orderId;

  }

  @JsonProperty("merchantOrderReference")
  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }
}
