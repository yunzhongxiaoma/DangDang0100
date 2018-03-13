package com.dangdang.entity;

import java.io.Serializable;

public class Goods implements Serializable{
	private Integer GID;
	private String picaddress;
	private String name;
	private String author;
	private String publisher;
	private String describe;
	private double originalPrice;
	private double dangdangPrice;
	private String publishingTime;
	private double revision;
	private String printingTime;
	private double impression;
	private String iisbn;
	private double wordsNumber;
	private double pagesNumber;
	private double format;
	private String paper;
	private String packaging;
	private String editorRecommende;
	private String briefContent;
	private String briefAuthor;
	private String catalog;
	private String mediaReviews;
	private String illustration;
	private String sheleTime;
	private int bookState;
	private long stock;
	private long sales;
	private int score;
	private int recommendedLevel;
	private int d_cateid;
	private Category category;
	
	public Goods() {
		super();
	}
	public Goods(Integer gID, String picaddress, String name, String author,
			String publisher, String describe, double originalPrice,
			double dangdangPrice, String publishingTime, double revision,
			String printingTime, double impression, String iisbn,
			double wordsNumber, double pagesNumber, double format,
			String paper, String packaging, String editorRecommende,
			String briefContent, String briefAuthor, String catalog,
			String mediaReviews, String illustration, String sheleTime,
			int bookState, long stock, long sales, int score,
			int recommendedLevel, int d_cateid, Category category) {
		super();
		GID = gID;
		this.picaddress = picaddress;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.describe = describe;
		this.originalPrice = originalPrice;
		this.dangdangPrice = dangdangPrice;
		this.publishingTime = publishingTime;
		this.revision = revision;
		this.printingTime = printingTime;
		this.impression = impression;
		this.iisbn = iisbn;
		this.wordsNumber = wordsNumber;
		this.pagesNumber = pagesNumber;
		this.format = format;
		this.paper = paper;
		this.packaging = packaging;
		this.editorRecommende = editorRecommende;
		this.briefContent = briefContent;
		this.briefAuthor = briefAuthor;
		this.catalog = catalog;
		this.mediaReviews = mediaReviews;
		this.illustration = illustration;
		this.sheleTime = sheleTime;
		this.bookState = bookState;
		this.stock = stock;
		this.sales = sales;
		this.score = score;
		this.recommendedLevel = recommendedLevel;
		this.d_cateid = d_cateid;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getD_cateid() {
		return d_cateid;
	}

	public void setD_cateid(int d_cateid) {
		this.d_cateid = d_cateid;
	}

	public String getPicaddress() {
		return picaddress;
	}

	public void setPicaddress(String picaddress) {
		this.picaddress = picaddress;
	}
	
	public Integer getGID() {
		return GID;
	}
	
	public void setGID(Integer gID) {
		GID = gID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDangdangPrice() {
		return dangdangPrice;
	}

	public void setDangdangPrice(double dangdangPrice) {
		this.dangdangPrice = dangdangPrice;
	}

	public String getPublishingTime() {
		return publishingTime;
	}

	public void setPublishingTime(String publishingTime) {
		this.publishingTime = publishingTime;
	}

	public double getRevision() {
		return revision;
	}

	public void setRevision(double revision) {
		this.revision = revision;
	}

	public String getPrintingTime() {
		return printingTime;
	}

	public void setPrintingTime(String printingTime) {
		this.printingTime = printingTime;
	}

	public double getImpression() {
		return impression;
	}

	public void setImpression(double impression) {
		this.impression = impression;
	}

	public String getIisbn() {
		return iisbn;
	}

	public void setIisbn(String iisbn) {
		this.iisbn = iisbn;
	}

	public double getWordsNumber() {
		return wordsNumber;
	}

	public void setWordsNumber(double wordsNumber) {
		this.wordsNumber = wordsNumber;
	}

	public double getPagesNumber() {
		return pagesNumber;
	}

	public void setPagesNumber(double pagesNumber) {
		this.pagesNumber = pagesNumber;
	}

	public double getFormat() {
		return format;
	}

	public void setFormat(double format) {
		this.format = format;
	}

	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getEditorRecommende() {
		return editorRecommende;
	}

	public void setEditorRecommende(String editorRecommende) {
		this.editorRecommende = editorRecommende;
	}

	public String getBriefContent() {
		return briefContent;
	}

	public void setBriefContent(String briefContent) {
		this.briefContent = briefContent;
	}

	public String getBriefAuthor() {
		return briefAuthor;
	}

	public void setBriefAuthor(String briefAuthor) {
		this.briefAuthor = briefAuthor;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getMediaReviews() {
		return mediaReviews;
	}

	public void setMediaReviews(String mediaReviews) {
		this.mediaReviews = mediaReviews;
	}

	public String getIllustration() {
		return illustration;
	}

	public void setIllustration(String illustration) {
		this.illustration = illustration;
	}

	public String getSheleTime() {
		return sheleTime;
	}

	public void setSheleTime(String sheleTime) {
		this.sheleTime = sheleTime;
	}

	public int getBookState() {
		return bookState;
	}

	public void setBookState(int bookState) {
		this.bookState = bookState;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public long getSales() {
		return sales;
	}

	public void setSales(long sales) {
		this.sales = sales;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRecommendedLevel() {
		return recommendedLevel;
	}

	public void setRecommendedLevel(int recommendedLevel) {
		this.recommendedLevel = recommendedLevel;
	}

	@Override
	public String toString() {
		return "Goods [GID=" + GID + ", picaddress=" + picaddress + ", name="
				+ name + ", author=" + author + ", publisher=" + publisher
				+ ", describe=" + describe + ", originalPrice=" + originalPrice
				+ ", dangdangPrice=" + dangdangPrice + ", publishingTime="
				+ publishingTime + ", revision=" + revision + ", printingTime="
				+ printingTime + ", impression=" + impression + ", iisbn="
				+ iisbn + ", wordsNumber=" + wordsNumber + ", pagesNumber="
				+ pagesNumber + ", format=" + format + ", paper=" + paper
				+ ", packaging=" + packaging + ", editorRecommende="
				+ editorRecommende + ", briefContent=" + briefContent
				+ ", briefAuthor=" + briefAuthor + ", catalog=" + catalog
				+ ", mediaReviews=" + mediaReviews + ", illustration="
				+ illustration + ", sheleTime=" + sheleTime + ", bookState="
				+ bookState + ", stock=" + stock + ", sales=" + sales
				+ ", score=" + score + ", recommendedLevel=" + recommendedLevel
				+ ", d_cateid=" + d_cateid + ", category=" + category + "]";
	}
	
}
