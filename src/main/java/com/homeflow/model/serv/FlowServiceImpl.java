package com.homeflow.model.serv;

import com.homeflow.model.entities.Flow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by vladimir on 08.12.16.
 */
@Service
public class FlowServiceImpl implements FlowService {

    @Resource
    private FlowRepository flowRepository;

    @Transactional
    @Override
    public Flow create(Flow flow) {
        Flow createdFlow = flow;
        return flowRepository.save(createdFlow);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Flow delete(int id) throws Exception {
        Flow deletedFlow = flowRepository.findOne((long) id);
        if (deletedFlow == null)
        throw new Exception();
        flowRepository.delete(deletedFlow);
        return deletedFlow;
    }

    @Transactional
    @Override
    public List<Flow> findAll() {
        return flowRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Flow update(Flow flow) throws Exception {
        Flow updatedFlow = flowRepository.findOne(flow.getId());
        if (updatedFlow == null)
        throw new Exception();
        updatedFlow.setName(flow.getName());
        //updatedFlow.setCategory(flow.getCategory());
        updatedFlow.setComment(flow.getComment());
        updatedFlow.setMoment(flow.getMoment());
        updatedFlow.setQty(flow.getQty());
        updatedFlow.setType(flow.getType());
        updatedFlow.setSumma(flow.getSumma());
        return updatedFlow;
    }

    @Transactional
    @Override
    public Flow findById(int id) {
        return flowRepository.findOne((long) id);
    }
}
