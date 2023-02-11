package ru.namazov.keme.specification;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class QuoteSpecification {
    @JsonProperty
    private long quoteId;
    @JsonProperty
    private boolean findById;
    @JsonProperty
    private boolean randomQuote;
    @JsonProperty
    private boolean top10;
    @JsonProperty
    private boolean worst10;
}
