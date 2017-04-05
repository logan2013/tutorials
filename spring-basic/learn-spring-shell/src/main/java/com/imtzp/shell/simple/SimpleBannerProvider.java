
package com.imtzp.shell.simple;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultBannerProvider;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleBannerProvider extends DefaultBannerProvider {

	@Override
	public String getBanner() {

		StringBuffer buf = new StringBuffer();
		buf.append("=======================================").append(OsUtils.LINE_SEPARATOR);
		buf.append("*          Baeldung Shell             *").append(OsUtils.LINE_SEPARATOR);
		buf.append("=======================================").append(OsUtils.LINE_SEPARATOR);
		buf.append("Version:").append(this.getVersion());
		return buf.toString();

	}

	@Override
	public String getVersion() {
		return "1.0.1";
	}

	@Override
	public String getWelcomeMessage() {
		return "Welcome to Logan CLI";
	}

	@Override
	public String getProviderName() {
		return "Logan Banner";
	}
}
