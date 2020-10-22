package com.salesteam.demo.services;

import com.salesteam.demo.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "agentService")
public class AgentServiceImpl implements AgentService{
    @Autowired
    AgentsRepository restrepos;
}
