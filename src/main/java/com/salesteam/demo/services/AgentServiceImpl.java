package com.salesteam.demo.services;

import com.salesteam.demo.models.Agent;
import com.salesteam.demo.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {
    @Autowired
    AgentsRepository restrepos;

    @Override
    public Agent save(Agent agent){
        return restrepos.save(agent);
    }
}
