//
// Created by dugang on 2018/5/10.
//

#ifndef MYFFMPEG_GPU_VIDEO_SL_AUDIO_H
#define MYFFMPEG_GPU_VIDEO_SL_AUDIO_H
#include <jni.h>

int open_gpu(JNIEnv *env , const char*path , jobject win);
int playOrPause_gpu();
//就是暂停
int justPause_gpu();
int destroy_gpu();
int seekPos(double pos);
int clearAllQue();
int getPlayPosition();
#endif //MYFFMPEG_GPU_VIDEO_SL_AUDIO_H