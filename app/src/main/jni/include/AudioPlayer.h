//
// Created by dugang on 2018/7/5.
//

#ifndef MYFFMPEG_AUDIOPLAYER_H
#define MYFFMPEG_AUDIOPLAYER_H
#include <GLES2/gl2.h>
#include <SLES/OpenSLES_Android.h>
#include "my_data.h"
#include "Notify.h"
#include "MyThread.h"
#include <queue>

class AudioPlayer : public Notify , public MyThread{
private :

    SLObjectItf engineOpenSL ;
    SLPlayItf iplayer ;
    SLEngineItf eng ;
    SLObjectItf mix ;
    SLObjectItf player ;
    SLAndroidSimpleBufferQueueItf pcmQue;
    SLEngineItf createOpenSL();
    int initAudio();
    int simpleRate ;
    int channel;
    int maxFrame = 100;
    void audioPlayDelay();
public :
    std::queue<MyData> audioFrameQue;
    char *playAudioTemp;
    AudioPlayer(int simpleRate , int channel);
    ~AudioPlayer();
    void changeSpeed(float speed);
    void update(MyData mydata);
    void run();
    int64_t pts;
};

#endif //MYFFMPEG_AUDIOPLAYER_H