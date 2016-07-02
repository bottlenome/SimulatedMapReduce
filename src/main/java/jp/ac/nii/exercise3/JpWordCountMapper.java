package jp.ac.nii.exercise3;

import jp.ac.nii.mapreduceframework.Context;
import jp.ac.nii.mapreduceframework.Mapper;

/**
 * このファイルは完成しています。
 */
public class JpWordCountMapper extends Mapper<Long, String, String, Integer> {

	@Override
	protected void map(Long key, String line, Context context) {
		for (String word : Tokenizer.tokenize(line)) {
			context.write(word.toLowerCase(), 1);
		}
	}

}
