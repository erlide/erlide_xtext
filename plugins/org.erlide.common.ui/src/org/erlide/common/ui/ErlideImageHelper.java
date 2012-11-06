package org.erlide.common.ui;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.IImageHelper;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.SynchronousBundleListener;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow
 */
@Singleton
public class ErlideImageHelper implements IImageHelper,
		SynchronousBundleListener {

	private final Map<ImageDescriptor, Image> registry = Maps
			.newHashMapWithExpectedSize(10);

	private AbstractUIPlugin plugin;

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.PluginImageHelper.pathSuffix")
	private String pathSuffix = "icons/"; //$NON-NLS-1$

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.PluginImageHelper.defaultImage")
	private String defaultImage = "default.gif"; //$NON-NLS-1$

	@Inject(optional = true)
	@Named("org.eclipse.xtext.ui.PluginImageHelper.notFound")
	private String notFound = "notFound.gif"; //$NON-NLS-1$

	public ErlideImageHelper() {
		plugin = CommonUiPlugin.getDefault();
	}

	/**
	 * Returns the image associated with the given image descriptor.
	 * 
	 * @param descriptor
	 *            the image descriptor for which the helper manages an image, or
	 *            <code>null</code> for a missing image descriptor
	 * @return the image associated with the image descriptor or
	 *         <code>null</code> if the image descriptor can't create the
	 *         requested image.
	 */
	@Override
	public Image getImage(ImageDescriptor descriptor) {
		if (descriptor == null) {
			descriptor = ImageDescriptor.getMissingImageDescriptor();
		}

		Image result = registry.get(descriptor);
		if (result != null) {
			return result;
		}
		result = descriptor.createImage();
		if (result != null) {
			registry.put(descriptor, result);
		}
		return result;
	}

	/**
	 * Disposes all images managed by this image helper.
	 */
	public void dispose() {
		for (Iterator<Image> iter = registry.values().iterator(); iter
				.hasNext();) {
			Image image = iter.next();
			image.dispose();
		}
		registry.clear();
	}

	@Inject
	public void hookBundleListener(AbstractUIPlugin aplugin) {
		aplugin.getBundle().getBundleContext().addBundleListener(this);
	}

	@Override
	public Image getImage(String imageName) {
		System.out.println("-----------------------" + imageName);

		String imgname = imageName == null ? defaultImage : imageName;
		if (imgname != null) {
			Image result = null;
			URL imgUrl = getPlugin().getBundle().getEntry(
					getPathSuffix() + imgname);
			if (imgUrl != null) {
				ImageDescriptor id = null;
				result = getPlugin().getImageRegistry().get(
						imgUrl.toExternalForm());
				if (result == null) {
					id = ImageDescriptor.createFromURL(imgUrl);
					if (id != null) {
						result = id.createImage();
						getPlugin().getImageRegistry().put(
								imgUrl.toExternalForm(), result);
					}
				}
				System.out.println(result);
				return result;
			}
			if (!imgname.equals(notFound)) {
				System.out.println(notFound);
				return getImage(notFound);
			}
		}
		System.out.println("null");
		return null;
	}

	public void setPathSuffix(String pathSuffix) {
		this.pathSuffix = pathSuffix;
	}

	public String getPathSuffix() {
		return pathSuffix;
	}

	public void setPlugin(AbstractUIPlugin plugin) {
		this.plugin = plugin;
	}

	public AbstractUIPlugin getPlugin() {
		return plugin;
	}

	public void setNotFound(String notFound) {
		this.notFound = notFound;
	}

	public String getNotFound() {
		return notFound;
	}

	public String getDefaultImage() {
		return defaultImage;
	}

	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage;
	}

	@Override
	public void bundleChanged(BundleEvent event) {
		if (event.getType() == BundleEvent.STOPPING
				&& event.getBundle().getBundleId() == getPlugin().getBundle()
						.getBundleId()) {
			dispose();
		}
	}

}
