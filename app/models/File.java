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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class File extends Model {
	private static final long serialVersionUID = 659588489962684809L;

	@Id
	private Long id;
	
	@Required
	@Column(nullable = false)
	private String name;
	
	@Required
	@Column(nullable = false)
	private String extension;
	
	@Required
	@Column(nullable = false)
	private String mimeType;
	
	@Lob
	@Required
	@Column(nullable = false)
	private byte[] content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}
}
