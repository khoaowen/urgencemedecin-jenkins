package urgence_medecin.importer;

import java.util.List;

import javafx.util.Pair;

/**
 * This class generates the SQL statements for updating a list of Post Ids
 * (referenced to POST object in Wordpress) of the table {@code wpp9_postmeta}.
 * 
 * <pre>
 * 
insert into wpp9_postmeta values(	391350	,6454	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391351	,6455	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391352	,6456	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391353	,6457	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391354	,6459	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391355	,6460	,"variable5"	,"au plus proche de votre domicile en un temps record");
insert into wpp9_postmeta values(	391356	,6461	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
insert into wpp9_postmeta values(	391357	,6462	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
insert into wpp9_postmeta values(	391358	,6463	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
insert into wpp9_postmeta values(	391359	,6464	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
insert into wpp9_postmeta values(	391360	,6465	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
insert into wpp9_postmeta values(	391361	,6521	,"variable5"	,"proche de l'endroit où vous habitez en quelques secondes");
 * 
 * </pre>
 * 
 * with :
 * <ul>
 * <li>first value is the new meta ID to be inserted (incremented manually
 * here)</li>
 * <li>second value is the post ids (in the example are the ids of the
 * departements)</li>
 * <li>third value is the meta key of the POD to be updated</li>
 * <li>forth value is the meta value of the POD to be updated</li>
 * 
 * @author khoa
 *
 */
public class MetaDatasUpdater {

	private MetaDatasUpdater() {
	}

	/**
	 * Insert new lines to database
	 * 
	 * @param firstMetaId The first meta ID to be incremented
	 * @param metaKey     The variable meta key
	 * @param postIds     List of POST objects to be updated
	 * @param metaValues  The list of all possible values for the variable metakey
	 * @return
	 */
	public static Pair<String, Long> insertStatements(Long firstMetaId, String metaKey, List<Long> postIds,
			List<String> metaValues) {
		StringBuilder bd = new StringBuilder();
		int innerLoopSize = postIds.size() / metaValues.size();
		Long incrementMetaId = firstMetaId;
		for (int i = 0; i < postIds.size(); i++) {
			bd.append(String.format("insert into wpp9_postmeta values(	%d	,%d	,\"%s\"	,\"%s\");\n", incrementMetaId,
					postIds.get(i), metaKey, metaValues.get(i / innerLoopSize % metaValues.size())));
			incrementMetaId++;
		}
		return new Pair<String, Long>(bd.toString(), incrementMetaId);
	}

	public static String updateStatements(String variable, List<Long> postIds, List<String> valuesOfHeader) {
		StringBuilder bd = new StringBuilder();
		for (int i = 0; i < postIds.size(); i++) {
			bd.append(String.format(
					"update wpp9_postmeta set meta_value = \"%s\" where post_id=%d and meta_key=\"%s\";\n",
					valuesOfHeader.get(i % valuesOfHeader.size()), postIds.get(i), variable));
		}
		return bd.toString();
	}

}
