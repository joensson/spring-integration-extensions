/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.aws.s3;

import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.springframework.util.Assert;

/**
 * Filters out the files by matching the given File name against the given regex
 * Uses Apache Commons IO {@link RegexFileFilter} internally
 *
 * @author Amol Nayak
 *
 * @since 0.5
 *
 */
public class RegexFileNameFilter extends AbstractFileNameFilter {
	private final IOFileFilter filter;

	/**
	 * Default constructor accepting the regex
	 * @param regex
	 */
	public RegexFileNameFilter(String regex) {
		Assert.hasText(regex, "Regex should be non null, non empty String");
		filter = new RegexFileFilter(regex);
	}


	/* (non-Javadoc)
	 * @see org.springframework.integration.aws.s3.FileNameFilter#accept(java.lang.String)
	 */

	@Override
	public boolean isFileNameAccepted(String fileName) {
		return filter.accept(null, fileName);
	}

}
