/*******************************************************************************
 * Copyright 2017 Bstek
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.bstek.uflo.process.node.exception;

import com.bstek.uflo.process.node.TaskNode;

/**
 * @author Jacky.gao
 * @since 2015年8月12日
 */
public class AssignException extends RuntimeException {
	private TaskNode taskNode;
	private static final long serialVersionUID = -7276567238830869572L;
	public AssignException(String message,TaskNode taskNode) {
		super(message);
		this.taskNode = taskNode;
	}
	public TaskNode getTaskNode() {
		return taskNode;
	}
}
