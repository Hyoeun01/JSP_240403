package org.zerock.applicationtest.service;

import org.zerock.applicationtest.dao.ProgramDAO;
import org.zerock.applicationtest.dto.ProgramDTO;

import java.util.List;

public enum ProgramService {

    INSTANCE;
    private ProgramDAO dao = new ProgramDAO();

    public List<ProgramDTO> listAll() throws Exception{
        return dao.selectAllProgram();
    }

    public ProgramDTO getProgram(String title) throws Exception {
        return dao.selectOneProgram(title);
    }
}
