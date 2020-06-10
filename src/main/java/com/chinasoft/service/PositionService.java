package com.chinasoft.service;

import com.chinasoft.pojo.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionService {

    List<Position> selectAll();

    void deletePos(List<Long> ids);

    void insertPos(Position position);

    void updatePos(Position position);

    Position selectPosById(Long id);

    int countPos();

    List<Position> selectPosByPage(int page);
}
