package gp.queue.L推荐结果打散;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class KuaiShouEx2 {
    public static void main(String[] args) {
        List<String> picAndVideoList = new ArrayList<>();
        picAndVideoList.add("v_0");
        picAndVideoList.add("v_1");
        picAndVideoList.add("v_2");
        picAndVideoList.add("p_3");
        picAndVideoList.add("p_4");
        picAndVideoList.add("p_5");
        picAndVideoList.add("v_6");
        picAndVideoList.add("p_7");
        picAndVideoList.add("v_8");
        picAndVideoList.add("v_9");
        List<String> result = new KuaiShouEx2().getRecommendenResult(picAndVideoList, 4);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public List<String> getRecommendenResult(List<String> picAndVideo, int maxInterval) {
        List<String> result = new ArrayList<>();
        if (picAndVideo == null || picAndVideo.size() == 0) {
            return result;
        }
        Queue<String> videoQueue = new LinkedList<>();
        Queue<String> picQueue = new LinkedList<>();
        boolean firstPic = false;
        int index = 0;
        int picAndVideoSize = picAndVideo.size();
        while (!firstPic && index < picAndVideoSize) {
            if (isVideo(picAndVideo.get(index))) {
                result.add(index, picAndVideo.get(index));
                index++;
            } else {
                firstPic = true;
            }
        }
        while (index < picAndVideoSize) {
            if (isVideo(picAndVideo.get(index))) {
                videoQueue.add(picAndVideo.get(index));
            } else {
                picQueue.add(picAndVideo.get(index));
            }
            index++;
        }
        int currentSize = result.size();
        while (!videoQueue.isEmpty() && !picQueue.isEmpty()) {
            if (currentSize >= maxInterval) {
                result.add(picQueue.poll());
                currentSize = 0;
            } else {
                result.add(videoQueue.poll());
                currentSize++;
            }
        }
        while (!videoQueue.isEmpty()) {
            result.add(videoQueue.poll());
        }

        if (currentSize >= maxInterval && !picQueue.isEmpty()) {
            result.add(picQueue.poll());
        }
        return result;

    }

    public boolean isVideo(String clip) {
        if (clip.indexOf("v") != -1) {
            return true;
        }
        return false;
    }

}
