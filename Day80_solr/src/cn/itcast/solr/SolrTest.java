package cn.itcast.solr;

import java.io.IOException;

import javax.management.Query;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;

public class SolrTest {
	/**
	 * 添加
	 * @throws Exception 
	 * @throws SolrServerException 
	 */
	@Test
	public void createIndex() throws Exception{
		HttpSolrServer httpSolrServer = init();
		//新建document对象
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "1");
		document.addField("content", "Hello world!");
		
		httpSolrServer.add(document);
		httpSolrServer.commit();
	}
	/**
	 * 删除
	 * @return
	 * 
	 */
	@Test
	public void delteIndex() throws Exception{
		HttpSolrServer httpSolrServer = init();
		
		String id="1";
		httpSolrServer.deleteById(id);
		httpSolrServer.commit();
	}

	private HttpSolrServer init() {
		//创建Http
		String baseURL="http://localhost:8080/solr";
		HttpSolrServer httpSolrServer = new HttpSolrServer(baseURL);
		return httpSolrServer;
	}
	/**
	 * 查询
	 * @throws Exception 
	 */
	@Test
	public void  queryTest() throws Exception{
		HttpSolrServer httpSolrServer = init();
		//创建查询对象
		SolrQuery solrQuery = new SolrQuery();
		
		solrQuery.setQuery("*:*");
		QueryResponse response = httpSolrServer.query(solrQuery);
		SolrDocumentList results = response.getResults();
		System.out.println("搜索到的结果总数：" + results.getNumFound());

		// 遍历搜索结果
		for (SolrDocument solrDocument : results) {

		System.out.println("----------------------------------------------------");

			System.out.println("id：" + solrDocument.get("id"));
			System.out.println("content" + solrDocument.get("content"));
		}

	}
}
