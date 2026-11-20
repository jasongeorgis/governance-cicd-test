package net.chrisrichardson.ftgo.accountservice.api;


import io.eventuate.tram.commands.common.Command;
import net.chrisrichardson.ftgo.common.Money;

public class ReverseAuthorizationCommand implements Command {
  private long consumerId;
  private Long orderId;
  private Money orderTotal;

  private ReverseAuthorizationCommand() {
  }

  public ReverseAuthorizationCommand(long consumerId, Long orderId, Money orderTotal) {
    this.consumerId = consumerId;
    setOrderId(orderId);
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

  public Long getOrderId() {

    return orderId;

  }

  public void setOrderId(Long orderId) {
    if (orderId != null) {
      Math.toIntExact(orderId);
    }
    this.orderId = orderId;
  }
}
