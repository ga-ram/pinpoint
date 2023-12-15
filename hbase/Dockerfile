FROM openjdk:8u342-slim

ARG HBASE_VERSION=${HBASE_VERSION:-2.2.6}

ENV HBASE_REPOSITORY=http://apache.mirrors.pair.com/hbase
ENV HBASE_SUB_REPOSITORY=http://archive.apache.org/dist/hbase

ENV BASE_DIR=/opt/hbase
ENV HBASE_HOME=${BASE_DIR}/hbase-${HBASE_VERSION}

COPY scripts/hbase-create.hbase ${BASE_DIR}/hbase-create.hbase

RUN cd /usr/local/bin/ \
    && echo "#!/bin/bash\n" \
            "set -e\n" \
            "set -x\n" \
            "cp ${BASE_DIR}/hbase-create.hbase ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "\n" \
            "sed -i \"/AgentInfo/s/TTL => .[[:digit:]]*/TTL => ${AGENTINFO_TTL:-31536000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/AgentStatV2/s/TTL => .[[:digit:]]*/TTL => ${AGENTSTATV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/ApplicationStatAggre/s/TTL => .[[:digit:]]*/TTL => ${APPSTATAGGRE_TTL:-5184000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/ApplicationIndex/s/TTL => .[[:digit:]]*/TTL => ${APPINDEX_TTL:-31536000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/AgentLifeCycle/s/TTL => .[[:digit:]]*/TTL => ${AGENTLIFECYCLE_TTL:-5184000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/AgentEvent/s/TTL => .[[:digit:]]*/TTL => ${AGENTEVENT_TTL:-5184000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/StringMetaData/s/TTL => .[[:digit:]]*/TTL => ${STRINGMETADATA_TTL:-15552000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/ApiMetaData/s/TTL => .[[:digit:]]*/TTL => ${APIMETADATA_TTL:-31536000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/SqlMetaData_Ver2/s/TTL => .[[:digit:]]*/TTL => ${SQLMETADATA_TTL:-15552000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/TraceV2/s/TTL => .[[:digit:]]*/TTL => ${TRACEV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/ApplicationTraceIndex/s/TTL => .[[:digit:]]*/TTL => ${APPTRACEINDEX_TTL:-5184000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/ApplicationMapStatisticsCaller_Ver2/s/TTL => .[[:digit:]]*/TTL => ${APPMAPSTATCALLERV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/ApplicationMapStatisticsCallee_Ver2/s/TTL => .[[:digit:]]*/TTL => ${APPMAPSTATCALLEV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/ApplicationMapStatisticsSelf_Ver2/s/TTL => .[[:digit:]]*/TTL => ${APPMAPSTATSELFV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"/HostApplicationMap_Ver2/s/TTL => .[[:digit:]]*/TTL => ${HOSTAPPMAPV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-create.hbase\n" \
            "sed -i \"s/create/alter/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/AgentInfo/s/TTL => .[[:digit:]]*/TTL => ${AGENTINFO_TTL:-31536000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/AgentStatV2/s/TTL => .[[:digit:]]*/TTL => ${AGENTSTATV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/ApplicationStatAggre/s/TTL => .[[:digit:]]*/TTL => ${APPSTATAGGRE_TTL:-5184000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/ApplicationIndex/s/TTL => .[[:digit:]]*/TTL => ${APPINDEX_TTL:-31536000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/AgentLifeCycle/s/TTL => .[[:digit:]]*/TTL => ${AGENTLIFECYCLE_TTL:-5184000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/AgentEvent/s/TTL => .[[:digit:]]*/TTL => ${AGENTEVENT_TTL:-5184000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/StringMetaData/s/TTL => .[[:digit:]]*/TTL => ${STRINGMETADATA_TTL:-15552000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/ApiMetaData/s/TTL => .[[:digit:]]*/TTL => ${APIMETADATA_TTL:-31536000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/SqlMetaData_Ver2/s/TTL => .[[:digit:]]*/TTL => ${SQLMETADATA_TTL:-15552000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/TraceV2/s/TTL => .[[:digit:]]*/TTL => ${TRACEV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/ApplicationTraceIndex/s/TTL => .[[:digit:]]*/TTL => ${APPTRACEINDEX_TTL:-5184000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/ApplicationMapStatisticsCaller_Ver2/s/TTL => .[[:digit:]]*/TTL => ${APPMAPSTATCALLERV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/ApplicationMapStatisticsCallee_Ver2/s/TTL => .[[:digit:]]*/TTL => ${APPMAPSTATCALLEV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/ApplicationMapStatisticsSelf_Ver2/s/TTL => .[[:digit:]]*/TTL => ${APPMAPSTATSELFV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "sed -i \"/HostApplicationMap_Ver2/s/TTL => .[[:digit:]]*/TTL => ${HOSTAPPMAPV2_TTL:-5184000}/g\" ${BASE_DIR}/hbase-update-ttl.hbase\n" \
            "\n" \
            "exec \"\$@\"\n" > /usr/local/bin/configure-hbase.sh

RUN echo "#!/bin/bash\n" \
         "\n" \
         "if echo -e \"exists 'HostApplicationMap_Ver2'\" | ${HBASE_HOME}/bin/hbase shell 2>&1 | grep -q \"does exist\" 2>/dev/null\n" \
         "\n" \
         "then\n" \
         "    echo \"Tables already exist\"\n" \
         "    #sleep 15\n" \
         "    #${HBASE_HOME}/bin/hbase shell ${BASE_DIR}/hbase-update-ttl.hbase\n" \
         "else\n" \
         "    sleep 15\n" \
         "    echo \"create tables\"\n" \
         "    ${HBASE_HOME}/bin/hbase shell ${BASE_DIR}/hbase-create.hbase\n" \
         "fi\n" > /usr/local/bin/check-table.sh

RUN echo "#!/bin/bash\n" \
         "\n" \
         "${HBASE_HOME}/bin/start-hbase.sh\n" \
         "/usr/local/bin/configure-hbase.sh\n" \
         "/usr/local/bin/check-table.sh\n" > /usr/local/bin/initialize-hbase.sh

RUN apt-get update && apt-get install --no-install-recommends -y curl && apt-get clean \
    && chmod a+x /usr/local/bin/initialize-hbase.sh \
    && chmod a+x /usr/local/bin/check-table.sh \
    && chmod a+x /usr/local/bin/configure-hbase.sh

RUN mkdir -p ${BASE_DIR} \
    && curl -fSL "${HBASE_REPOSITORY}/${HBASE_VERSION}/hbase-${HBASE_VERSION}-bin.tar.gz" -o hbase.tar.gz || curl -fSL "${HBASE_SUB_REPOSITORY}/${HBASE_VERSION}/hbase-${HBASE_VERSION}-bin.tar.gz" -o ${BASE_DIR}/hbase.tar.gz \
    && tar xfvz ${BASE_DIR}/hbase.tar.gz -C ${BASE_DIR} \
    && rm ${BASE_DIR}/hbase.tar.gz

RUN echo "<configuration>\n" \
    "    <property>\n" \
    "        <name>hbase.rootdir</name>\n" \
    "        <value>file:///home/pinpoint/hbase</value>" \
    "    </property>\n" \
    "    <property>\n" \
    "        <name>hbase.cluster.distributed</name>\n" \
    "        <value>true</value>\n" \
    "    </property>\n" \
    "     <property>\n" \
    "        <name>zookeeper.znode.parent</name>\n" \
    "        <value>/hbase</value>\n" \
    "    </property>\n" \
    "    <property>\n" \
    "        <name>hbase.zookeeper.quorum</name>\n" \
    "        <value>zoo1,zoo2,zoo3</value>\n" \
    "    </property>\n" \
    "    <property>\n" \
    "		<name>hbase.zookeeper.property.clientPort</name>\n" \
    "		<value>2181</value>\n" \
    "	</property>\n" \
    "    <property>\n" \
    "        <name>hbase.master.port</name>\n" \
    "        <value>60000</value>\n" \
    "    </property>\n" \
    "    <property>\n" \
    "        <name>hbase.regionserver.port</name>\n" \
    "        <value>60020</value>\n" \
    "    </property>\n" \
    "</configuration>\n" > ${HBASE_HOME}/conf/hbase-site.xml

RUN echo "export HBASE_OPTS=\"-XX:+UseConcMarkSweepGC\n\"" \
    "export HBASE_MASTER_OPTS=\"$HBASE_MASTER_OPTS -XX:PermSize=128m -XX:MaxPermSize=128m\"\n" \
    "export HBASE_REGIONSERVER_OPTS=\"$HBASE_REGIONSERVER_OPTS -XX:PermSize=128m -XX:MaxPermSize=128m\"\n" \
    "export HBASE_MANAGES_ZK=false" > ${HBASE_HOME}/conf/hbase-env.sh

VOLUME ["/home/pinpoint/hbase", "/home/pinpoint/zookeeper"]

CMD /usr/local/bin/initialize-hbase.sh && tail -f /dev/null
