package study.mycat.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface IKMapper<T> extends Mapper<T>, MySqlMapper<T> {
}