package com.chenq.aspose.generator;

import com.aspose.words.Document;
import com.aspose.words.ImportFormatMode;

/**
 * @author chenq
 * 2016-9-8 上午9:03:33
 */
public class DocBuilder {
	private Document doc;

	private DocBuilder(Builder builder) {
		this.doc = builder.doc;
	}

	public Document getDoc() {
		return this.doc;
	}

	public static class Builder {
		private Document doc;

		public Builder append(Document document) {
			try {
				if (doc == null) {
					doc = document;
				} else if (document != null) {
					doc.appendDocument(document, ImportFormatMode.KEEP_DIFFERENT_STYLES);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this;
		}

		public DocBuilder build() {
			return new DocBuilder(this);
		}
	}
}
