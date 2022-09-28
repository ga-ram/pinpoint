package com.navercorp.pinpoint.metric.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.navercorp.pinpoint.common.util.CollectionUtils;
import com.navercorp.pinpoint.metric.common.model.StringPrecondition;
import com.navercorp.pinpoint.metric.common.model.UriStat;
import com.navercorp.pinpoint.metric.web.view.TimeSeriesValueView;
import com.navercorp.pinpoint.metric.web.view.TimeseriesValueGroupView;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UriStatGroup implements TimeseriesValueGroupView {
    private final String uri;

    private final List<TimeSeriesValueView> values;

    public static final UriStatGroup EMPTY_URI_STAT_GROUP = new UriStatGroup();

    public UriStatGroup() {
        this.uri = StringUtils.EMPTY;
        this.values = Collections.EMPTY_LIST;
    }

    public UriStatGroup(String uri, List<UriStat> uriStats) {
        this.uri = uri;
        this.values = UriStatValue.createValueList(uriStats);
    }

    @Override
    public String getGroupName() {
        return uri;
    }

    @Override
    public List<TimeSeriesValueView> getMetricValues() {
        return values;
    }

    public static class UriStatValue implements TimeSeriesValueView {
        private static final String FIELD_PREFIX = "histogram";
        private final String fieldName;
        private final List<Integer> values;

        public static List<TimeSeriesValueView> createValueList(List<UriStat> uriStats) {
            Objects.requireNonNull(uriStats);
            List<TimeSeriesValueView> values = new ArrayList<>();

            final int bucketSize = uriStats.get(0).getTotalHistogram().length;
            for (int i = 0 ; i < bucketSize; i++) {
                final int histogramIndex = i;
                values.add(new UriStatValue(FIELD_PREFIX + histogramIndex,
                        uriStats.stream().map(e -> e.getTotalHistogram()[histogramIndex]).collect(Collectors.toList())));
            }
            return values;
        }

        public UriStatValue(String fieldName, List<Integer> values) {
            this.fieldName = StringPrecondition.requireHasLength(fieldName, "fieldName");
            this.values = Objects.requireNonNull(values);
        }

        @Override
        public String getFieldName() { return fieldName; }

        @Override
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public List<String> getTags() { return null; }

        @Override
        public List<Integer> getValues() { return values; }
    }
}
