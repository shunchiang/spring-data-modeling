package com.salesteam.demo.services;

import com.salesteam.demo.models.Agent;

import java.util.List;

public interface AgentService {
    List<Agent> findAllAgents();

    Agent save(Agent agent);

    Agent findAgentById(long agentcode);
}
