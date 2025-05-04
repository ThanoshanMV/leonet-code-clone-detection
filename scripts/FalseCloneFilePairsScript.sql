SELECT DISTINCT ON (function_id_one, function_id_two) function_id_one, function_id_two, functionality_id, type, similarity_line, similarity_token, syntactic_type, min_judges, min_confidence
	FROM public.false_positives;
	
-- Create unique False Clone "file pairs" from "functional pairs"
SELECT DISTINCT ON (fc.file_one, abc.name) fc.function_id_one, fc.file_one, fc.file_one_directory, fc.function_id_two, abc.name AS file_two, abc.type AS file_two_directory, fc.functionality_id, fc.type, fc.syntactic_type, fc.similarity_line, fc.similarity_token
	FROM 
(SELECT c.function_id_one, c.function_id_two, f.name AS file_one, f.type AS file_one_directory, c.functionality_id, c.type, c.syntactic_type, c.similarity_line, c.similarity_token
	FROM public.false_positives AS c INNER JOIN public.functions AS f
	ON c.function_id_one = f.id) AS fc INNER JOIN public.functions AS abc
	ON fc.function_id_two = abc.id
	ORDER BY fc.file_one, abc.name
	LIMIT 2100;
	