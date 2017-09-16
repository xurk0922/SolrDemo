package cn.xurongkun.student.service;

import cn.xurongkun.base.service.BaseService;
import cn.xurongkun.student.entity.Student;
import cn.xurongkun.student.index.StudentIndex;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class StudentServiceImpl implements BaseService<StudentIndex> {
    private SolrClient client = null;

    {
        if (this.client == null) {
            Configurations configs = new Configurations();
            try {
                Configuration config = configs.properties(new File("config.properties"));

                String url = config.getString("solr.url");
                String core = "student";

                this.client = new HttpSolrClient.Builder(url+"/"+core).build();
            }
            catch (ConfigurationException cex) {
                cex.printStackTrace();
            }
        }
    }

    @Override
    public void clear() {
        try {
            UpdateResponse response = this.client.deleteByQuery("*:*");

            response.getResponse().size();
            this.client.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(StudentIndex studentIndex) {
        try {
            this.client.addBean(studentIndex);


            client.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }


    }

    @Override
    public String query(String statement, Integer start, Integer rows, String... fields) {
        SolrQuery query = new SolrQuery();
        query.setQuery(statement);
        query.setFields(fields);
        try {
            QueryResponse response = this.client.query(query);
            SolrDocumentList list = response.getResults();
            return JSON.toJSONString(list);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JSONArray().toJSONString();
    }

    @Override
    public void delete(Long id) {
        try {
            this.client.deleteById(id.toString());
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByQuery(String statement) {
        try {
            this.client.deleteByQuery(statement);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
