package io.demo2;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by dancheng on 2018/11/5.
 */
public class MyFilter implements FileFilter{
	@Override
	public boolean accept(File pathname) {
		if(pathname.isDirectory())
			return true;
		return pathname.getName().endsWith(".java");
	}
}
