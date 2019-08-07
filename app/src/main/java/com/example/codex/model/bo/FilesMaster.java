package com.example.codex.model.bo;

import java.io.Serializable;


public class FilesMaster implements Serializable {
	private Long idFile;
	private Long clientid;
	private Long projectid;
	private Long assetid;
	private Long ticketid;
	private Long ticketreplyid;
	private String filename;
	private String file;
	private Long proposal_id;
	private Long sdd_id;
	private Long pdd_id;
	private Long implementation_id;
	private Long env_apps_id;
	private Long project_dev_id;
	private Long env_access_prov_id;
	private Long env_soft_id;
	private Long env_res_id;
	private Long env_sec_firewall_id;
	private Long kb_article_id;

	public Long getIdFile() {
		return idFile;
	}

	public void setIdFile(Long idFile) {
		this.idFile = idFile;
	}

	public Long getClientid() {
		return clientid;
	}

	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}

	public Long getProjectid() {
		return projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	public Long getAssetid() {
		return assetid;
	}

	public void setAssetid(Long assetid) {
		this.assetid = assetid;
	}

	public Long getTicketid() {
		return ticketid;
	}

	public void setTicketid(Long ticketid) {
		this.ticketid = ticketid;
	}

	public Long getTicketreplyid() {
		return ticketreplyid;
	}

	public void setTicketreplyid(Long ticketreplyid) {
		this.ticketreplyid = ticketreplyid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Long getProposal_id() {
		return proposal_id;
	}

	public void setProposal_id(Long proposal_id) {
		this.proposal_id = proposal_id;
	}

	public Long getSdd_id() {
		return sdd_id;
	}

	public void setSdd_id(Long sdd_id) {
		this.sdd_id = sdd_id;
	}

	public Long getPdd_id() {
		return pdd_id;
	}

	public void setPdd_id(Long pdd_id) {
		this.pdd_id = pdd_id;
	}

	public Long getImplementation_id() {
		return implementation_id;
	}

	public void setImplementation_id(Long implementation_id) {
		this.implementation_id = implementation_id;
	}

	public Long getEnv_apps_id() {
		return env_apps_id;
	}

	public void setEnv_apps_id(Long env_apps_id) {
		this.env_apps_id = env_apps_id;
	}

	public Long getProject_dev_id() {
		return project_dev_id;
	}

	public void setProject_dev_id(Long project_dev_id) {
		this.project_dev_id = project_dev_id;
	}

	public Long getEnv_access_prov_id() {
		return env_access_prov_id;
	}

	public void setEnv_access_prov_id(Long env_access_prov_id) {
		this.env_access_prov_id = env_access_prov_id;
	}

	public Long getEnv_soft_id() {
		return env_soft_id;
	}

	public void setEnv_soft_id(Long env_soft_id) {
		this.env_soft_id = env_soft_id;
	}

	public Long getEnv_res_id() {
		return env_res_id;
	}

	public void setEnv_res_id(Long env_res_id) {
		this.env_res_id = env_res_id;
	}

	public Long getEnv_sec_firewall_id() {
		return env_sec_firewall_id;
	}

	public void setEnv_sec_firewall_id(Long env_sec_firewall_id) {
		this.env_sec_firewall_id = env_sec_firewall_id;
	}

	public Long getKb_article_id() {
		return kb_article_id;
	}

	public void setKb_article_id(Long kb_article_id) {
		this.kb_article_id = kb_article_id;
	}

}
