/**
 * Copyright © 2019 Lhasa Limited
 * File created: 19 Aug 2019 by Tima Camara
 * Creator : Tima Camara
 * Version : $Id$
 */
package org.lhasalimited.etransafe.wp6.clinical.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to OpenAPI api documentation
 * 
 * @author Tima Camara
 * @since 19 Aug 2019
 */
@Controller
public class HomeController
{

	@RequestMapping("/")
	public String index()
	{
		return "redirect:swagger-ui.html";

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