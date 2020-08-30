package com.cslp.ken.number1244;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leaderboard {

  // key 人员 value 分数
  private Map<Integer,Integer> m_rank;
  // key 分数 value 同分人数
  private TreeMap<Integer,Integer> m_score;// 分数

  public Leaderboard() {
    m_rank = new HashMap<>();
    m_score = new TreeMap<>();
  }

  public void addScore(int playerId, int score) {
    Integer oldScore = m_rank.get(playerId);
    if (oldScore != null) {
      // 旧积分人数处理
      oldScoreNumProcess(oldScore);
      score += oldScore;
    }
    // 选手分数更新
    m_rank.put(playerId,score);
    // 分数排名更新
    m_score.put(score,m_score.getOrDefault(score,0) + 1);
  }

  private void oldScoreNumProcess(int score){
    int scoreNum = m_score.get(score);
    if (scoreNum <= 1){
      // 该积分没有人了，积分移除
      m_score.remove(score);
    } else {
      // 该积分人数减一
      m_score.put(score,scoreNum - 1);
    }
  }

  public int top(int K) {
    int sumScore = 0;
    // 最大的积分
    Map.Entry<Integer,Integer> scoreEntry = m_score.lastEntry();
    while (K > 0 && scoreEntry != null){
      // key 分数 value 人数
      // 积分人数如果大于K了，取K个人，否则全部取出
      int num = Math.min(scoreEntry.getValue(),K);
      // 分数*数量
      sumScore += scoreEntry.getKey() * num;
      // 分数前移，找小的
      scoreEntry = m_score.lowerEntry(scoreEntry.getKey());
      K-= num;
    }
    return sumScore;
  }

  public void reset(int playerId) {
    // 选手积分
    int score = m_rank.get(playerId);
    // 选手积分清零
    m_rank.put(playerId,0);
    // 积分人数处理
    oldScoreNumProcess(score);
    // 0分人数+1
    m_score.put(0,m_score.getOrDefault(0,0) + 1);
  }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */

