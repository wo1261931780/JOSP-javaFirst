package wo1261931780.javaFirst.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel("返回结果")
public class ShowResult<T> {
	@ApiModelProperty("返回类型")
	private Integer code;
	// 这里前端和后端拿到的变量必须一致，否则直接res.code会无法跳转

	@ApiModelProperty("返回信息")
	private String msg;
	@ApiModelProperty("返回数据")
	private T data;
	private Map map = new HashMap();

	/**
	 * 请求成功
	 *
	 * @param object 对象
	 * @param <T>    成功消息/实体类
	 * @return 返回结果
	 */
	public static <T> ShowResult<T> sendSuccess(T object) {
		ShowResult<T> tShowResult = new ShowResult<>();
		tShowResult.setData(object);
		tShowResult.setCode(1);
		return tShowResult;
	}

	/**
	 * 请求失败
	 *
	 * @param returnMsg 失败消息
	 * @param <T>       失败消息/实体类
	 * @return 返回结果
	 */
	public static <T> ShowResult<T> sendError(String returnMsg) {
		ShowResult<T> tShowResult = new ShowResult<>();
		tShowResult.setCode(0);
		tShowResult.setMsg(returnMsg);
		return tShowResult;
	}
}