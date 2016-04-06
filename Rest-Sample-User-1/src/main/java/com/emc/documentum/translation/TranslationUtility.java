package com.emc.documentum.translation;

import java.util.ArrayList;

import org.apache.commons.collections4.BidiMap;
import org.springframework.beans.factory.annotation.Autowired;

import com.emc.documentum.dtos.DocumentumObject;
import com.emc.documentum.dtos.DocumentumProperty;

public class TranslationUtility {

	@Autowired
	private TranslationMapWrapper mapWrapper;

	public DocumentumObject transelateToRepo(DocumentumObject object, String Repo ,boolean directionFromRepo) {

		ArrayList<DocumentumProperty> objectProperties = object.getDocProperties();
		String translation = null;
		for (int i = 0; i < objectProperties.size(); i++) {

			//Properties prop = mapWrapper.propertiesMap.get(Repo+".mapping.properties") ;
			//translation = prop.getProperty(objectProperties.get(i).getLocalName());
			BidiMap<String,String> map = mapWrapper.bidiMapsMap.get(Repo+".mapping.properties") ;
			if(directionFromRepo)
			{
				translation = map.get(objectProperties.get(i).getLocalName());
			}
			else
			{
				translation = map.getKey(objectProperties.get(i).getLocalName());
			}
			
			// set the translation in object ...
			objectProperties.get(i).setLocalName(translation);
		}
		return object;
	}
}
