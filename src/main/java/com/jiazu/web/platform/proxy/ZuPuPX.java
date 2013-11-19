/**
 * 
 * ============================================================================
 * 声明：北京旺族互联网科技有限公司版权所有
 * ----------------------------------------------------------------------------
 * Official Website: http://www.jiazuww.com
 * ----------------------------------------------------------------------------
 * Copyright: © 2012 JiaZuWW All Rights Reserved.
 * ----------------------------------------------------------------------------
 * @version: 1.0
 * ----------------------------------------------------------------------------
 * @author: Architect.bian
 * ----------------------------------------------------------------------------
 * Create at: 2012-9-9 上午11:38:46
 * ============================================================================
 */
package com.jiazu.web.platform.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import com.jiazu.core.cache.Rule;
import com.jiazu.core.cache.impl.CacheFacade;
import com.jiazu.core.cache.rule.SysRule;
import com.jiazu.global.constants.CacheKeyConstant;
import com.jiazu.global.constants.MsgConstant;
import com.jiazu.global.constants.SysConf;
import com.jiazu.web.base.proxy.BasePX;
import com.jiazu.web.platform.entity.Jiazu;
import com.jiazu.web.platform.entity.News;
import com.jiazu.web.platform.entity.ZupuMember;
import com.jiazu.web.platform.service.ZupuMemberSO;
import com.jiazu.web.shop.entity.Content;

/**
 * @author Architect.bian
 *
 */
public class ZuPuPX extends BasePX {

	private static final int ancestorlevel = 0;

	/**
	 * @return
	 */
	public static int getCreatedCount() {
		return JiazuPX.getCount();
	}

	/**
	 * @param i
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Jiazu> getLatest(int i) {
		try {
			List<Jiazu> list = (List<Jiazu>)CacheFacade.get(new SysRule(CacheKeyConstant.latestJiazu));
			if (list == null || list.size() == 0) {
				list = new ArrayList<Jiazu>();
				Jiazu jiazu = new Jiazu();
				jiazu.setName("李家族谱");
				list.add(jiazu);
				jiazu = new Jiazu();
				jiazu.setName("李家族谱修改名称");
				list.add(jiazu);
				jiazu = new Jiazu();
				jiazu.setName("李家族谱修改名称2");
				list.add(jiazu);
			}
			return list;
		} catch (Exception e) {
			logException(LoggerFactory.getLogger(ZuPuPX.class), e);
			return null;
		}
	}
	
	public static boolean addLatestJiazu(String name) {
		SysRule rule = new SysRule(CacheKeyConstant.latestJiazu);
		Jiazu jiazu = new Jiazu(name);
		try {
			return insertLatestJiazu(rule, jiazu);
		} catch (Exception e) {
			logException(LoggerFactory.getLogger(ZuPuPX.class), e);
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	private static boolean insertLatestJiazu(Rule rule, Jiazu jiazu) throws Exception {
		List<Jiazu> list = (List<Jiazu>)CacheFacade.get(rule);
		if (list == null) {
			list = new ArrayList<Jiazu>();
		} else if (list.size() >= SysConf.maxSizeLatestJiazu) {
			list.remove(SysConf.maxSizeLatestJiazu - 1);
		}
		list.add(0, jiazu);
		CacheFacade.set(rule, list);
		return true;
	}

	/**
	 * 从缓存中读取
	 * @param i 读取数量
	 * @return
	 */
	public static List<News> getZuPuNews(int i) {
		try {
			return SysPX.getZupuNews();
		} catch (Exception e) {
			logException(LoggerFactory.getLogger(ZuPuPX.class), e);
			return null;
		}
	}

	/**
	 * @return
	 */
	public static Content getIntroduce() {
		return ContentPX.getZupuIntroduce();
	}

	/**
	 * @param uid
	 * @return
	 */
	public static List<ZupuMember> getMembers(String groupuid, boolean insertroot) {
		ZupuMemberSO so = (ZupuMemberSO)spring.getBean(ZupuMemberSO.class);
		List<ZupuMember> list = so.getList(groupuid);
		if (insertroot) {
			ZupuMember top = new ZupuMember();
			top.setUid("ancestor");
			top.setName("祖先");
			top.setName2("");
			top.setLevel(0);
			top.setParentuid("root");
			for (ZupuMember m : list) {
				if (m.getLevel() == 1) {
					m.setParentuid(top.getUid());
				}
			}
			list.add(0, top);
		}
		return list;
//		List<ZupuMember> list = new ArrayList<>();
//		
//		ZupuMember m = new ZupuMember();
//		m.setAvatar("/imgs/default/noimg50_50.gif");
//		m.setAvatar2("/imgs/webimgs/head2.jpg");
//		m.setName("老张三");
//		m.setName2("老李四");
//		m.setGender(EGender.Gentleman);
//		m.setGender2(EGender.Lady);
//		m.setLevel(1);
//		m.setParentuid("");
//		m.setStatus(EStatus.enable);
//		m.setStatus2(EStatus.disable);
//		list.add(m);
//		List<ZupuMember> list2 = new ArrayList<>();
//		List<ZupuMember> list3 = new ArrayList<>();
//		for (int i = 0; i < 3; i++) {
//			ZupuMember m2 = new ZupuMember();
//			m2.setAvatar("/imgs/webimgs/head1.jpg");
//			m2.setAvatar2("/imgs/webimgs/head2.jpg");
//			m2.setName("张三");
//			m2.setName2("李四");
//			m2.setGender(EGender.Gentleman);
//			m2.setGender2(EGender.Lady);
//			m2.setLevel(2);
//			m2.setParentuid(m.getUid());
//			m2.setStatus(EStatus.enable);
//			m2.setStatus2(EStatus.disable);
//			list.add(m2);
//			for (int j = 0; j < 2; j++) {
//				ZupuMember m22 = new ZupuMember();
//				m22.setAvatar("/imgs/webimgs/head1.jpg");
//				m22.setAvatar2("/imgs/webimgs/head2.jpg");
//				m22.setName("小张三" + String.valueOf(i) + j);
//				m22.setName2("小李四" + String.valueOf(i) + j);
//				m22.setGender(EGender.Gentleman);
//				m22.setGender2(EGender.Lady);
//				m22.setLevel(3);
//				m22.setParentuid(m2.getUid());
//				m22.setStatus(EStatus.enable);
//				m22.setStatus2(EStatus.disable);
//				list2.add(m22);
//				for (int k = 0; k < 2; k++) {
//					ZupuMember m33 = new ZupuMember();
//					m33.setAvatar("/imgs/webimgs/head1.jpg");
//					m33.setAvatar2("/imgs/webimgs/head2.jpg");
//					m33.setName("小张三" + String.valueOf(i) + j);
//					m33.setName2("小李四" + String.valueOf(i) + j);
//					m33.setGender(EGender.Gentleman);
//					m33.setGender2(EGender.Lady);
//					m33.setLevel(4);
//					m33.setParentuid(m22.getUid());
//					m33.setStatus(EStatus.enable);
//					m33.setStatus2(EStatus.disable);
//					list3.add(m33);
//				}
//			}
//		}
//		list.addAll(list2);
//		list.addAll(list3);
//		return list;
	}
	
	/**
	 * @param uid
	 * @return
	 */
	public static String getJsonMembers(String groupuid) {
		List<ZupuMember> list = getMembers(groupuid, false);
		int len = list.size();
		list = organizeMembers(list.toArray(new ZupuMember[len]), 1);
		return parseMembersToJson(list);
	}

	/**
	 * 通过zupumember的list获得json格式的数据
	 * 生成的格式：
	 * [
{"id": "5ed44ef28603402b8dd768663bb3383d","text": "张三 |  李四","expanded": true,"children":
	[
	{"id": "626ed291e13e4f5f8a7e451bb2cfccaa","text": "null | null","expanded": true,"children":
		[
		{"id": "b3ea7ca534974e2fa8928b92d9534428","text": "null | null","expanded": true},
		{"id": "9609c5116d1442d09c19c8c67f4c9c3d","text": "null | null","expanded": true}
		]
	},
	{"id": "5ad31a024fee4622807474fd83f4a038","text": "null | null","expanded": true,"children":
		[
		{"id": "564863a1ef124d4ebbcc2d9b9cf8fe5a","text": "null | null","expanded": true},
		{"id": "82054ef522494013bb918c73d7553aaa","text": "null | null","expanded": true}
		]
	},
	{"id": "8a65fc2e959243778847cdb7a549ec0e","text": "null | null","expanded": true,"children":
		[
		{"id": "88b5804d220e4962b59730d72b58c2fd","text": "null | null","expanded": true},
		{"id": "5e2a48d77fed47c0a36d7e349133fa1d","text": "null | null","expanded": true}
		]
	}
	]
}
	 * @param list
	 * @return
	 */
	private static String parseMembersToJson(List<ZupuMember> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		String jsonformat = "{\"id\": \"%1s\",\"text\": \"%2s | %3s\",\"expanded\": true}";
		String jsonformatchildren = "{\"id\": \"%1s\",\"text\": \"%2s | %3s\",\"expanded\": true,\"children\":%4s}";
		int len = list.size();
		for (int i = 0; i < len; i++) {
			ZupuMember item = list.get(i);
			if (item.getChildren().size() > 0) {
				sb.append(String.format(jsonformatchildren, item.getUid(), item.getName(), item.getName2(), parseMembersToJson(item.getChildren())));
			} else {
				sb.append(String.format(jsonformat, item.getUid(), item.getName(), item.getName2()));
			}
			if ((i + 1) != len) {
				sb.append(",");
			} else {
				
			}
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * @param list
	 */
	private static List<ZupuMember> organizeMembers(ZupuMember[] members, int toplevel) {
		List<ZupuMember> list = new ArrayList<>();
		
		int len = members.length;
		for (int i = 0; i < len; i++) {
			ZupuMember member = members[i];
			if (member.getLevel() == toplevel) {
				list.add(organizeChildren(member, ArrayUtils.subarray(members, i + 1, len)));
			} else {
				break;
			}
		}
		return list;
	}

	/**
	 * @param member
	 * @param zupuMembers
	 * @return
	 */
	private static ZupuMember organizeChildren(ZupuMember member, ZupuMember[] array) {
		int len = array.length;
		for (int i = 0; i < len; i++) {
			ZupuMember item = array[i];
			if (item.getLevel() > member.getLevel() + 1) {
				break;
			}
			if (item.getParentuid().equals(member.getUid())) {
				member.getChildren().add(organizeChildren(item, ArrayUtils.subarray(array, i + 1, len)));
			}
		}
		return member;
	}

	/**
	 * @param member
	 * @return
	 */
	public static boolean add(ZupuMember member) {
		ZupuMemberSO so = (ZupuMemberSO)spring.getBean(ZupuMemberSO.class);
		return so.add(member);
	}

	/**
	 * @param selecteduid
	 * @return
	 */
	public static boolean delete(String uid) {
		ZupuMemberSO so = (ZupuMemberSO)spring.getBean(ZupuMemberSO.class);
		return so.delete(uid);
	}

	/**
	 * @param selecteduid
	 * @return
	 */
	public static ZupuMember get(String uid) {
		ZupuMemberSO so = (ZupuMemberSO)spring.getBean(ZupuMemberSO.class);
		return so.get(uid);
	}

	/**
	 * @param uid
	 * @return
	 */
	public static String getHtmlTree(String uid) {
		List<ZupuMember> members = getMembers(uid, true);
		StringBuffer sb = new StringBuffer();
		if (members.size() > 0) {
			int width = organizeCascadeChildren(members);
			width = 340 * width;
			int height = (members.get(members.size() - 1).getLevel() + 1) * 100;
			for (ZupuMember mem : members) {
				if (mem.getLevel() == ancestorlevel) {
					sb.append("<ul style=\"width:" + width + "px; height:" + height + "px;\">");
					sb.append(generalTopLeaf(mem));
					sb.append(generalChildrenLeafs(mem));
					sb.append("</ul>");
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 对所有member重组，将child添加到children中，得到最底层的member
	 * @param members
	 * @return 某一Level节点的最大数量
	 */
	private static int organizeCascadeChildren(List<ZupuMember> members) {
		Map<String, ZupuMember> map = new HashMap<String, ZupuMember>();
		int currlevel = 0;
		int lastlevel = 0;
		int j = 1;
		int j_max = 1;
		for (ZupuMember mem : members) {
			if (mem.getLevel() == ancestorlevel) {
				map.put(mem.getUid(), mem);
			} else {
				currlevel = mem.getLevel();
				if (currlevel == lastlevel) {
					j++;
				} else {
					j = 1;
					lastlevel = currlevel;
				}
				if (j > j_max) {
					j_max = j;
				}
				if (map.containsKey(mem.getParentuid())) {
					map.get(mem.getParentuid()).getChildren().add(mem);
					map.put(mem.getUid(), mem);
				} else {
					System.out.println("error");
				}
			}
		}
		return j_max;
	}

	/**
	 * @param mem
	 * @return
	 */
	private static String generalChildrenLeafs(ZupuMember mem) {
		StringBuffer sb = new StringBuffer();
		if (mem.getLevel() == ancestorlevel) {
			if (mem.getChildren().size() > 0) {
				int len = mem.getChildren().size();
				int halfsize = len / 2;
				int h = halfsize + 1;
				List<?> lefthalf = mem.getChildren().subList(0, h);
				List<?> righthalf = mem.getChildren().subList(h, len);
				List<?>[] leftbranchs = {lefthalf};
				List<?>[] rightbranchs = {righthalf};
				if (leftbranchs.length > 0 || rightbranchs.length > 0) {
					sb.append("<li>");
					sb.append(generalLeftBranchs(leftbranchs));
					sb.append(generalRightBranchs(rightbranchs));
					sb.append("</li>");
					sb.append(generalChildrenLeafs(lefthalf, righthalf));
				}
			}
		} else {
			sb.append(MsgConstant.err_data);
		}
		return sb.toString();
	}

	/**
	 * @param lefthalf
	 * @param righthalf
	 * @return
	 */
	private static String generalChildrenLeafs(List<?> lefthalf, List<?> righthalf) {
		List<List<ZupuMember>> leftBranchs = new ArrayList<List<ZupuMember>>();
		List<List<ZupuMember>> rightBranchs = new ArrayList<List<ZupuMember>>();
		List<Object> leftChildren = new ArrayList<Object>();
		List<Object> rightChildren =  new ArrayList<Object>();
		StringBuffer sb = new StringBuffer();
		for (Object obj : lefthalf) {
			ZupuMember mem = (ZupuMember)obj;
			if (mem.getChildren().size() > 0) {
				leftBranchs.add(mem.getChildren());
				for (Object child : mem.getChildren()) {
					leftChildren.add(child);
				}
			}
		}
		for (Object obj : righthalf) {
			ZupuMember mem = (ZupuMember)obj;
			if (mem.getChildren().size() > 0) {
				rightBranchs.add(mem.getChildren());
				for (Object child : mem.getChildren()) {
					rightChildren.add(child);
				}
			}
		}
		if (leftBranchs.size() > 0 || rightBranchs.size() > 0) {
			sb.append("<li>");
			sb.append("<div class=\"txtcen\">");
			sb.append(generalLeftBranchs(leftBranchs.toArray(new List<?>[0])));
			sb.append(generalRightBranchs(rightBranchs.toArray(new List<?>[0])));
			sb.append("</div>");
			sb.append("</li>");
			sb.append(generalChildrenLeafs(leftChildren, rightChildren));
		}
		return sb.toString();
	}
	
	/**
	 * @param leftbranchs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static Object generalLeftBranchs(List<?>[] leftbranchs) {
		StringBuffer sb = new StringBuffer();
		int len = leftbranchs.length;
		for (int i = 0; i < len; i++) {
			List<ZupuMember> members = (List<ZupuMember>)leftbranchs[i];
			int size = members.size();
			int flag = size - 1;
			int lastmemchildrensize = members.get(size - 1).getChildren().size();
			int branchmargin = lastmemchildrensize == 0 ? 0 : (lastmemchildrensize  * 60 + 50);
			if (i == 0) {
				int j = 0;
				while (size > 0 && ++j < members.get(0).getLevel()) {
					//sb.append("<div class=\"w60 right\"></div>");
				}
				//sb.append("<div class=\"leftbranch\" style=\"margin-left:" + branchmargin + "px;\">");
			} else {
				//sb.append("<div class=\"leftbranch mrgt60\" style=\"margin-left:" + branchmargin + "px;\">");//.append("<div class=\"mlft60\"></div>");
			}
			for (int j = 0; j < size; j++) {
				ZupuMember mem = members.get(j);
				int leftpx = 60;
				int childrensize = mem.getChildren().size();
				String bottom = "";
				if (childrensize > 1) {
					leftpx += childrensize * leftpx;
				} else {
					bottom = "bottom";
				}
				if (j < flag) {
					sb.append("<div id=\"" + mem.getUid() + "\" data-p=\"" + mem.getParentuid() + "\" class=\"leaf ").append(bottom).append("\" style=\"margin-left: ").append(leftpx).append("px;\">");
					sb.append(generalLeaf(mem));
					sb.append("</div>");
				} else {
					if (size == 1) {
						//sb.append("<div class=\"w60 left\"></div>");
					}
					sb.append("<div id=\"" + mem.getUid() + "\" data-p=\"" + mem.getParentuid() + "\" class=\"leftleaf ").append(bottom).append("\">");
					sb.append(generalLeaf(mem));
					sb.append("</div>");
				}
			}
			//sb.append("</div>");
		}
		return sb;
	}

	/**
	 * @param mem
	 * @return
	 */
//	private static int getMaxChildrenSize(ZupuMember mem) {
//		int size = 0;
//		int lastlevel = 1;
//		int maxsize = 0;
//		for (ZupuMember m : mem.getChildren()) {
//			int currlevel = m.getLevel();
//			if (currlevel != lastlevel) {
//				lastlevel = currlevel;
//				size = 1;
//			}
//			size++;
//			if (maxsize < size) {
//				maxsize = size;
//			}
//		}
//		return size;
//	}
	
	/**
	 * @param rightbranchs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static Object generalRightBranchs(List<?>[] rightbranchs) {
		StringBuffer sb = new StringBuffer();
		int len = rightbranchs.length;
		//sb.append("<div class=\"half\">");
		for (int i = 0; i < len; i++) {
			List<ZupuMember> members = (List<ZupuMember>)rightbranchs[i];
			int size = members.size();
			if (size == 0) {
				break;
			}
			int flag = size - 1;
			int lastmemchildrensize = members.get(size - 1).getChildren().size();
			int branchmargin = lastmemchildrensize == 0 ? 0 : (lastmemchildrensize  * 60 + 50);
			if (i == 0) {
				int j = 0;
				while (size > 0 && ++j < members.get(0).getLevel()) {
					//sb.append("<div class=\"w60 left\"></div>");
				}
				//sb.append("<div class=\"rightbranch\" style=\"margin-right:" + branchmargin + "px;\">");
			} else {
				//sb.append("<div class=\"rightbranch mlft60\" style=\"margin-right:" + branchmargin + "px;\">");//.append("<div class=\"mlft60\"></div>");
			}
			for (int j = 0; j < size; j++) {
				ZupuMember mem = members.get(j);
				int leftpx = 60;
				int childrensize = mem.getChildren().size();
				String bottom = "";
				if (childrensize > 1) {
					leftpx += childrensize * leftpx;
				} else {
					bottom = "bottom";
				}
				if (j < flag) {
					sb.append("<div  id=\"" + mem.getUid() + "\" data-p=\"" + mem.getParentuid() + "\" class=\"leaf ").append(bottom).append("\" style=\"margin-right: ").append(leftpx).append("px;\">");
					sb.append(generalLeaf(mem));
					sb.append("</div><div class=\"w60 left\"></div>");
				} else {
					if (size == 1) {
						sb.append("<div class=\"w60 left\"></div>");
					}
					sb.append("<div id=\"" + mem.getUid() + "\" data-p=\"" + mem.getParentuid() + "\" class=\"rightleaf ").append(bottom).append("\">");
					sb.append(generalLeaf(mem));
					sb.append("</div>");
				}
			}
			//sb.append("</div>");
		}
		//sb.append("</div>");
		return sb;
	}

	/**
	 * @param zupuMember
	 * @return
	 */
	private static String generalTopLeaf(ZupuMember mem) {
		String html = "<li class=\"firstli\"><div id=\"" + mem.getUid() + "\" class=\"top leaf\">" + generalLeaf(mem) + "</div></li>";
		return html;
	}

	/**
	 * @param mem
	 * @return
	 */
	private static String generalLeaf(ZupuMember mem) {
		//String format = "<div class=\"head1\"><img src=\"/jiazu/imgs/webimgs/head1.jpg\" alt=\"head1\" /></div><div class=\"head2\"><img src=\"/jiazu/imgs/webimgs/head2.jpg\" alt=\"head2\" /></div><div class=\"vline\"></div>";
		String format1 = "<div class=\"head1 " + mem.getStatus().name() + "\"><img src=\"%s\" alt=\"" + mem.getName() + "\" /><div class=\"tagbg\"></div><div class=\"tag\">%s</div></div>";
		String format2 = "<div class=\"head2 " + mem.getStatus2().name() + "\"><img src=\"%s\" alt=\"" + mem.getName2() + "\" /><div class=\"tagbg\"></div><div class=\"tag\">%s</div></div>";
		String str = "";
		if (StringUtils.isNotEmpty(mem.getName())) {
			str += String.format(format1, mem.getAvatar(), mem.getName());
		}
		if (StringUtils.isNotEmpty(mem.getName2())) {
			str += String.format(format2, mem.getAvatar2(), mem.getName2());
		}
		return str;
	}

	/**
	 * @param m
	 * @return
	 */
	public static boolean update(ZupuMember m) {
		ZupuMemberSO so = (ZupuMemberSO)spring.getBean(ZupuMemberSO.class);
		return so.update(m);
	}

}
