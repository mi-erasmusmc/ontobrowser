/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.api;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.NativeWebRequest;

/**
 * 
 * @author Tima Camara
 * @since 19 Aug 2019
 */
public class ApiUtil
{
	public static void setExampleResponse(NativeWebRequest req, String contentType, String example)
	{
		try
		{
			HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
			res.setCharacterEncoding("UTF-8");
			res.addHeader("Content-Type", contentType);
			res.getWriter().print(example);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
/* ---------------------------------------------------------------------*
 * This software is the confidential and proprietary
 * information of Lhasa Limited
 * Granary Wharf House, 2 Canal Wharf, Leeds, LS11 5PS
 * ---
 * No part of this confidential information shall be disclosed
 * and it shall be used only in accordance with the terms of a
 * written license agreement entered into by holder of the information
 * with LHASA Ltd.
 * --------------------------------------------------------------------- */
