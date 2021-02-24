package kg.nurik.finalproject.ui.onBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kg.nurik.finalproject.R
import kg.nurik.finalproject.data.model.onBoard.OnBoardModel
import kotlinx.android.synthetic.main.fragment_onboard.*

class OnBoardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        val data = arguments?.get(DATA_ID) as OnBoardModel
        title.text = data.title
        image.setImageResource(data.image)
    }

    companion object {
        const val DATA_ID = "DATA_ID"

        fun getInstance(data: OnBoardModel): OnBoardFragment {
            val fragment = OnBoardFragment()
            val bundle = Bundle()
            bundle.putParcelable(DATA_ID, data)
            fragment.arguments = bundle
            return fragment
        }
    }

}