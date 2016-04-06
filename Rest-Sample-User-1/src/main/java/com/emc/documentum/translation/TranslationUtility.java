package com.emc.documentum.translation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.emc.documentum.dtos.DocumentumDocument;
import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.dtos.DocumentumProperty;

//TODO should add here the properties files containing the translation values
@PropertySource("classpath:rest.properties")
public class TranslationUtility {

	@Autowired
	private Environment env;

	public DocumentumObject transelateToRepo(DocumentumObject object, String Repo) {

	}

	public DocumentumObject transelateFromRepo(DocumentumObject object, String Repo) {
		// TODO doing translation
		ArrayList<DocumentumProperty> objectProperties = object.getDocProperties();
		String translation = null;
		for (int i = 0; i < objectProperties.size(); i++) {
			translation = env.getProperty(Repo + ":" + objectProperties.get(i).getLocalName());
			// set the translation in object ...
		}
		return object;
	}

	public DocumentumDocument transelateToRepo(DocumentumDocument object, String Repo) {
		// TODO do translation

		return object;
	}

	public DocumentumDocument transelateFromRepo(DocumentumDocument object, String Repo) {
		// TODO do translation

		return object;
	}

}
