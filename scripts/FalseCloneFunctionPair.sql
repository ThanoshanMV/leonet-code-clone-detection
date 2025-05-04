-- coming! DISTICNCT ON (expression) must come in ORDER BY (expression) in the same order as they appear.
SELECT DISTINCT ON (abc.function_one, f.text) abc.function_id_one, abc.function_one, abc.function_id_two, f.text AS function_two, abc.functionality_id, abc.type, abc.similarity_line, abc.similarity_token, abc.syntactic_type, abc.min_judges, abc.min_confidence
FROM (SELECT fp.function_id_one, ppf.text AS function_one, fp.function_id_two, fp.functionality_id, fp.type, fp.similarity_line, fp.similarity_token, fp.syntactic_type, fp.min_judges, fp.min_confidence
	FROM public.false_positives AS fp INNER JOIN public.pretty_printed_functions AS ppf
 	ON fp.function_id_one = ppf.function_id) AS abc INNER JOIN public.pretty_printed_functions AS f
	ON abc.function_id_two = f.function_id ORDER BY abc.function_one, f.text LIMIT 4100;

-- No distinction
SELECT abc.function_id_one, abc.function_one, abc.function_id_two, f.text AS function_two, abc.functionality_id, abc.type, abc.similarity_line, abc.similarity_token, abc.syntactic_type, abc.min_judges, abc.min_confidence
FROM (SELECT fp.function_id_one, ppf.text AS function_one, fp.function_id_two, fp.functionality_id, fp.type, fp.similarity_line, fp.similarity_token, fp.syntactic_type, fp.min_judges, fp.min_confidence
	FROM public.false_positives AS fp INNER JOIN public.pretty_printed_functions AS ppf
 	ON fp.function_id_one = ppf.function_id) AS abc INNER JOIN public.pretty_printed_functions AS f
	ON abc.function_id_two = f.function_id LIMIT 4200;
	
