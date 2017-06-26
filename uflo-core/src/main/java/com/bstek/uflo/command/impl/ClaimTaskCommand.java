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
package com.bstek.uflo.command.impl;

import org.apache.commons.lang.StringUtils;

import com.bstek.uflo.command.Command;
import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.task.Task;
import com.bstek.uflo.model.task.TaskState;
import com.bstek.uflo.model.task.TaskType;

/**
 * @author Jacky.gao
 * @since 2013年8月13日
 */
public class ClaimTaskCommand implements Command<Task> {
	private Task task;
	private String user;
	public ClaimTaskCommand(Task task,String user){
		this.task=task;
		this.user=user;
	}
	public Task execute(Context context) {
		if(!task.getType().equals(TaskType.Participative)){
			throw new IllegalStateException("Current task ["+task.getTaskName()+"] is not a participative task!");
		}
		if(StringUtils.isNotEmpty(task.getAssignee())){
			throw new IllegalStateException("Current task ["+task.getTaskName()+"] has belonged to ["+task.getAssignee()+"].");
		}
		if(StringUtils.isBlank(user)){
			throw new IllegalStateException("User can not be null when task claim.");
		}
		task.setState(TaskState.Reserved);
		task.setAssignee(user);
		context.getSession().update(task);
		return task;
	}
}
