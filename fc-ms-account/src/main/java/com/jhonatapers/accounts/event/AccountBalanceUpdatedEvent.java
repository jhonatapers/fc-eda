package com.jhonatapers.accounts.event;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AccountBalanceUpdatedEvent(
                @JsonProperty("Name") String name,
                @JsonProperty("Payload") AccountBalanceUpdatedEvent.Payload payload)
                implements Event<AccountBalanceUpdatedEvent.Payload> {

        public static record Payload(
                        @JsonProperty("account_id_from") String account_id_from,
                        @JsonProperty("account_id_to") String accountIDTo,
                        @JsonProperty("balance_account_id_from") BigDecimal balanceAccountIDFrom,
                        @JsonProperty("balance_account_id_to") BigDecimal balanceAccountIDTo) {
        }

}
