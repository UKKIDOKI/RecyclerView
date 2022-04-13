package com.doit.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/*
어뎁터 클래스
어뎁터를 통해 아이템xml표시할 뷰홀더를 리사이클러뷰에 보여줌
 */

// 클래스 선언후 리사이클러뷰 어댑터를상속받음
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private ArrayList<MainData> arrayList;    // 리스트뷰에 아이템을 담아 어댑터에 셋팅할 데이터타입 어레이리스트 선언

    public MainAdapter(ArrayList<MainData> arrayList) { //메인어댑터 생성자 추가
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    //필수메서드 3개 구현
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //item xml 연결
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false); // 뷰타입 뷰에 레이아웃 인플레이터 클래스의 from 메서드 호출후 파라미터 전달
        ViewHolder holder = new ViewHolder(view); // 뷰홀더타입 홀더 객체 생성후 생성자로 뷰 변수 전달
        return holder; // 호출된곳으로 홀더를 반환
    }

    @Override

    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());    // 이미지리소스 메서드에 어레이리스트 겟 포지션값과 이미지뷰 아이디 전달후 홀더안의 변수에 저장
        holder.tv_name.setText(arrayList.get(position).getTv_name());   // 셋텍스트  메서드에 어레이리스트 겟 포지션값과 이미지뷰 아이디 전달후 홀더안의 변수에 저장
        holder.tv_content.setText(arrayList.get(position).getTv_content());     // 셋텍스트 메서드에 어레이리스트 겟 포지션값과 이미지뷰 아이디 전달후 홀더안의 변수에 저장


        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 리사이클러뷰 아이템이 클릭되었을때 이벤트 메서드
                String curName = holder.tv_name.getText().toString(); // 문자열타입 변수 선언후 홀더안의 네임변수에 들어온 데이터를 가져와 문자열 형태로 변환후 저장
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();  // 토스트로 뷰.겟컨텍스트 위에 저장된 변수 출력
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) { // 리사이클러뷰 아이템이 길게 클릭 되었을때 이벤트 메서드
                remove(holder.getAdapterPosition()); // 리무브 메서드 호출후 파라미터로 홀더의 포지션 값을 전달

                return true;


            }
        });
    }


    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);      // 어레이리스트 값이 널값이 아닐때 어레이리스트 사이즈메서드 , 어레이리스트 값이 널값일때 0을반환
    }


    // 리무브 메서드 선언
    // 트라이 캐치문

    public void remove(int positon) {
        try {
            arrayList.remove(positon);            // 어레이리스트 리무브 메서드에 포지션값을 전달
            notifyItemRemoved(positon);             // notifyItemRemoved 메서드에 포지션값 전달 // 리사이클러뷰 아이템 제거 메서드
        } catch (IndexOutOfBoundsException ex) {  // IndexOutOfBoundsException
            ex.printStackTrace(); // printStackTrace
        }
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
      // 위젯변수선언
        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_content;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // 뷰 가져오기
            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_content = itemView.findViewById(R.id.tv_content);


        }
    }
}
