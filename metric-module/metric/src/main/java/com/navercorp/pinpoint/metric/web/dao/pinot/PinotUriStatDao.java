package com.navercorp.pinpoint.metric.web.dao.pinot;

import com.navercorp.pinpoint.metric.common.model.UriStat;
import com.navercorp.pinpoint.metric.web.dao.UriStatDao;
import com.navercorp.pinpoint.metric.web.model.UriStatSummary;
import com.navercorp.pinpoint.metric.web.util.UriStatQueryParameter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class PinotUriStatDao implements UriStatDao {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private static final String NAMESPACE = PinotUriStatDao.class.getName() + ".";

    private final SqlSessionTemplate sqlPinotSessionTemplate;

    public PinotUriStatDao(SqlSessionTemplate sqlPinotSessionTemplate) {
        this.sqlPinotSessionTemplate = Objects.requireNonNull(sqlPinotSessionTemplate, "sqlPinotSessionTemplate");
    }

    @Override
    public List<UriStat> getUriStatApplication(UriStatQueryParameter queryParameter) {
        return sqlPinotSessionTemplate.selectList(NAMESPACE + "selectUriStatApplication", queryParameter);
    }

    @Override
    public List<UriStat> getUriStatAgent(UriStatQueryParameter queryParameter) {
        return sqlPinotSessionTemplate.selectList(NAMESPACE + "selectUriStatAgentId", queryParameter);
    }

    @Override
    public List<UriStatSummary> getUriStatApplicationSummary(UriStatQueryParameter queryParameter) {
        return sqlPinotSessionTemplate.selectList(NAMESPACE + "top50UriStatApplication", queryParameter);
    }

    @Override
    public List<UriStatSummary> getUriStatAgentSummary(UriStatQueryParameter queryParameter) {
        return sqlPinotSessionTemplate.selectList(NAMESPACE + "top50UriStatAgent", queryParameter);
    }
}
