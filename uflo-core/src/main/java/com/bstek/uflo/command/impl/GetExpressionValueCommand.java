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

import com.bstek.uflo.command.Command;
import com.bstek.uflo.env.Context;

/**
 * @author Jacky.gao
 * @since 2013年10月6日
 */
public class GetExpressionValueCommand implements Command<Object> {
	private long processInstanceId;
	private String key;
	public GetExpressionValueCommand(long processInstanceId,String key){
		this.processInstanceId=processInstanceId;
		this.key=key;
	}
	public Object execute(Context context) {
		return context.getExpressionContext().eval(processInstanceId, "${"+key+"}");
	}
}
