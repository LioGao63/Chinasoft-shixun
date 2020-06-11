package com.chinasoft.mapper;

import com.chinasoft.pojo.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper {

    //查询所有职位
    List<Position> selectAll();

    //删除选中的职位
    void deletePos(List<Long> ids);

    //插入新职位
    void insertPos(Position position);

    //更新信息
    void updatePos(Position position);

    //根据id查询职位
    Position selectPosById(Long id);

    //查询职位个数
    int countPos();

    //分页查询
    List<Position> selectPosByPage(int page);

    //模糊搜索
    List<Position> searchPos(String name);
}
