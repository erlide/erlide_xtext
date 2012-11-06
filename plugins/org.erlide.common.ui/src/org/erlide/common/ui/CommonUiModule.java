package org.erlide.common.ui;

import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.IImageHelper;

public class CommonUiModule extends AbstractGenericModule {

	public Class<? extends IImageHelper> bindIImageHelper() {
		return ErlideImageHelper.class;
	}

}
