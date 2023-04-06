package util;

//������ ó�� 
public class PageTest {
   private int pageSize=10;//�� ������ �� �� ����
   private int pageBlock=10;//���� ���̼� 10��
   private int curPage=1;//����������
   
   private int startRow;//�������� ���� �۹�ȣ 
   private int endRow;//�������� �� �۹�ȣ
   
   private int cnt;//�� �۰��� 
   private int pageCnt;//�� ������ ��
   
   private int startPage;//���� ������ 
   private int endPage;//�� ������ 

   private int prevBlock;//������
   private int nextBlock;//������
   
   
   public PageTest() {}//����Ʈ ������ 
   
   public PageTest(int cnt, int curPage) {//�����ִ� ������
      this.cnt=cnt;//�� �� ���� 
      this.curPage=curPage;//���� ������
      
      this.pageCnt=cnt/pageSize+(cnt%pageSize==0?0:1);//�� ������ ���ϱ� 
      
      this.startRow=(curPage-1)*pageSize+1;//�������� ���� �۹�ȣ
      this.endRow=curPage*pageSize;//�������� �� �۹�ȣ 
      
      this.startPage = (int)(curPage/pageBlock)*10+1;//���� ������
      this.endPage = startPage+pageBlock-1;//�� ������
       
      //if(currentPage%pageBlock==0 && currentPage>=pageBlock) {
                       //startPage=currentPage-9;
      //}
   }//������-end
   
   public int getPageSize() {
      return pageSize;
   }
 
   public int getPageBlock() {
      return pageBlock;
   }

   public int getCurPage() {
      return curPage;
   }


   public int getStartRow() {
      return startRow;
   }

   public int getEndRow() {
      return endRow;
   }

   public int getCnt() {
      return cnt;
   }

   public int getPageCnt() {
      return pageCnt;
   }

   public int getStartPage() {
      return startPage;
   }

   public int getEndPage() {//****************
      return endPage;
   }
   
   public void setEndPage(int endPage) {//****************
      this.endPage = endPage;
   }

   public int getPrevBlock() {
      this.prevBlock=startPage-10;
      return prevBlock;
   }

    

   public int getNextBlock() {
      this.nextBlock=startPage+10;
      return nextBlock;
   }

}