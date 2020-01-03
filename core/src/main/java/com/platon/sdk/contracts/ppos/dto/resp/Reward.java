package com.platon.sdk.contracts.ppos.dto.resp;

import org.web3j.utils.Numeric;

import java.math.BigInteger;

public class Reward {

    private String nodeId;
    private BigInteger stakingNum;
    private BigInteger reward;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public BigInteger getStakingNum() {
        return stakingNum;
    }

    public void setStakingNum(BigInteger stakingNum) {
        this.stakingNum = stakingNum;
    }

    public BigInteger getReward() {
        return reward;
    }

    public void setReward(String reward) {
        if (reward != null && reward.length() > 0) {
            this.reward = Numeric.decodeQuantity(reward);
        } else {
            this.reward = BigInteger.ZERO;
        }
    }

    @Override
    public String toString() {
        return "Reward{" +
                "nodeId='" + nodeId + '\'' +
                ", stakingNum=" + stakingNum +
                ", reward=" + reward +
                '}';
    }
}
