/*
 *  The Diztorted Dimension. Internet portal about underground music  
 *  Copyright (C) 2006-2012 Anton Podavalov, Valentin Dmitriev
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Article extends Model implements Noveltiable {
	private static final long serialVersionUID = 8183237934262033420L;

	@Id
	private Long id;
	
	@Required
	@Column(nullable = false)
	private String name;
	
	@Lob
	@Required
	@Column(nullable = false)
	private String text;
	
	@Required
	@Column(nullable = false)
	private Date postDate;
	
	@Required
	@ManyToOne
	@Column(nullable = false)
	private User user;
	
	@Required
	@Column(nullable = false)
	private String author;
	
	@Required
	@Column(nullable = false)
	private Boolean published;
	
	@Required
	@Column(nullable = false)
	private Date lastUpdated;
	
	@ManyToOne
	private Comment firstComment;
	
	@PreUpdate
	private void PreUpdate()
	{
		lastUpdated = new Date();
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public Long getId() {
		return id;
	}
	
	public Comment getFirstComment() {
		return firstComment;
	}

	public void setFirstComment(Comment firstComment) {
		this.firstComment = firstComment;
	}

	@Override
	public String getEntityType() {
		return "article";
	}
}
