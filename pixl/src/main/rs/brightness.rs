#pragma version(1)
#pragma rs java_package_name(com.example.android.basicrenderscript)
#pragma rs_fp_relaxed

float bright = 0.f;

/*
 * RenderScript kernel that performs brightness manipulation.
 */
uchar4 __attribute__((kernel)) brightness(uchar4 in)
{
    float4 f4 = rsUnpackColor8888(in);
    f4.x += bright;
    f4.y += bright;
    f4.z += bright;
    if(f4.x < 0.f || f4.y < 0.f || f4.z < 0.f){
       f4.x = 0.f;
       f4.y = 0.f;
       f4.z = 0.f;
    }
    return rsPackColorTo8888(f4);
}




