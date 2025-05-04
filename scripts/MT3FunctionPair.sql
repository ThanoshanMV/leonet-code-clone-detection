SELECT DISTINCT(syntactic_type) FROM public.clones; -- results: 1, 2, 3
	
-- MT3 (50% inclusive - 70% exclusive) functions pairs. 38894 rows. this number pairs is mentioned in the latest paper of BCB ("BigCloneEval: A Clone Detection Tool Evaluation Framework with BigCloneBench").
SELECT fc.function_id_one, fc.function_one, fc.function_id_two, abc.text AS function_two, fc.functionality_id, fc.type, fc.syntactic_type, fc.similarity_line, fc.similarity_token
	FROM 
(SELECT c.function_id_one, f.text AS function_one, c.function_id_two, c.functionality_id, c.type, c.syntactic_type, c.similarity_line, c.similarity_token
	FROM public.clones AS c INNER JOIN public.pretty_printed_functions AS f
	ON c.function_id_one = f.function_id
	WHERE c.syntactic_type = 3 AND (c.similarity_line >= 0.5 AND c.similarity_line < 0.7) AND (c.similarity_token >= 0.5 AND c.similarity_token < 0.7)) AS fc INNER JOIN public.pretty_printed_functions AS abc
	ON fc.function_id_two = abc.function_id LIMIT 4200;
	
