package org.nutz.el.opt.logic;

import java.util.Queue;

import org.nutz.el.El2Exception;
import org.nutz.el.opt.AbstractOpt;

/**
 * Not(!)
 * @author juqkai(juqkai@gmail.com)
 *
 */
public class NotOpt extends AbstractOpt{
	private Object right;
	
	public int fetchPriority() {
		return 7;
	}
	public void wrap(Queue<Object> rpn){
		right = rpn.poll();
	}
	
	public Object calculate() {
		Object rval = calculateItem(this.right);
		if(rval instanceof Boolean){
			return !(Boolean) rval;
		}
		throw new El2Exception("'!'操作符操作失败!");
	}
	
	public String fetchSelf() {
		return "!";
	}
}