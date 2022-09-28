package com.navercorp.pinpoint.metric.web.dao;

import com.navercorp.pinpoint.metric.common.model.UriStat;
import com.navercorp.pinpoint.metric.web.model.UriStatSummary;
import com.navercorp.pinpoint.metric.web.util.UriStatQueryParameter;

import java.util.List;

public interface UriStatDao {
    List<UriStat> getUriStatApplication(UriStatQueryParameter queryParameter);
    List<UriStat> getUriStatAgent(UriStatQueryParameter queryParameter);
    List<UriStatSummary> getUriStatApplicationSummary(UriStatQueryParameter uriStatQueryParameter);
    List<UriStatSummary> getUriStatAgentSummary(UriStatQueryParameter uriStatQueryParameter);
}
